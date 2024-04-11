package com.example.spaceshooter;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.LogRecord;

public class OnBattle extends View {
    Context context;
    Bitmap bg, lifeImg;
    android.os.Handler handler;
    long UPDATE_TIME = 30;
    static int screenWidth, screenHeight;
    int point = 0;
    int life = 3;
    Paint scorePaint;
    int textSize = 45;
    boolean pause = false;
    Player player;
    Enemy enemy;
    Random random;
    ArrayList<EnemyShoot> enemyShoot;
    ArrayList<PlayerShoot> playerShoot;

    boolean enemyExplosion = false;
    Explosion explosion;
    ArrayList<Explosion> explosions;
    boolean enemyShootactive = false;

    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public OnBattle(Context context) {
        super(context);

        this.context = context;
        random = new Random();
        enemyShoot = new ArrayList<>();
        playerShoot = new ArrayList<>();
        explosions = new ArrayList<>();

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        player = new Player(context);
        enemy = new Enemy(context);

        bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.battlebg1);
        lifeImg = BitmapFactory.decodeResource(context.getResources(), R.drawable.health);

        handler = new Handler();
        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(textSize);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawBitmap(bg, 0, 0, null);
        canvas.drawText("Point: " + point, 0, textSize, scorePaint);

        for(int i = life; i > 0; i--) {
            canvas.drawBitmap(lifeImg, screenWidth - lifeImg.getWidth() * i - 20, 10, null);
        }

        if (life == 0) {
            pause = true;
            handler = null;
            Intent intent = new Intent(context, BattleResultActivity.class);
            intent.putExtra("points", point);

            context.startActivity(intent);
            ((Activity) context).finish();
        }

        enemy.xPos += enemy.speed;
        if (enemy.xPos + enemy.getWidth() >= screenWidth || enemy.xPos <= 0) {
            enemy.speed *= -1;
        }

        if (enemyShootactive == false && enemy.xPos >= 200 + random.nextInt(520)) {
            EnemyShoot enemyShoot = new EnemyShoot(context, enemy.xPos + enemy.getWidth() / 2, enemy.yPos);
            this.enemyShoot.add(enemyShoot);
            enemyShootactive = true;
        }

        if (!enemyExplosion) {
            canvas.drawBitmap(enemy.getEnemySpaceship(),enemy.xPos, enemy.yPos, null);
        }
        if (player.alive == true) {
            if (player.xPos > screenWidth - player.getWidth()) {
                player.xPos = screenWidth - player.getWidth();
            }
            else if (player.xPos < 0) {
                player.xPos = 0;
            }
            canvas.drawBitmap(player.getPlayerSpaceship(), player.xPos, player.yPos, null);
        }
        for (int i = 0; i < enemyShoot.size(); i++) {
            enemyShoot.get(i).yPos += 15;
            canvas.drawBitmap(enemyShoot.get(i).getShoot(),enemyShoot.get(i).xPos, enemyShoot.get(i).yPos, null);

            if (enemyShoot.get(i).xPos >= player.xPos && enemyShoot.get(i).xPos <= player.xPos + player.getWidth() && enemyShoot.get(i).yPos >= player.yPos && enemyShoot.get(i).yPos <= screenHeight) {
                life--;
                enemyShoot.remove(i);
                explosion = new Explosion(context, player.xPos, player.yPos);
                explosions.add(explosion);
            }
            else if (enemyShoot.get(i).yPos >= screenHeight) {
                enemyShoot.remove(i);
            }

            if (enemyShoot.size() == 0) {
                enemyShootactive = false;
            }
        }

        for (int i = 0; i < playerShoot.size(); i++) {
            playerShoot.get(i).yPos -= 15;
            canvas.drawBitmap(playerShoot.get(i).getShoot(), playerShoot.get(i).xPos, playerShoot.get(i).yPos, null);
            if (playerShoot.get(i).xPos >= enemy.xPos && playerShoot.get(i).xPos <= enemy.xPos + enemy.getWidth() && playerShoot.get(i).yPos <= enemy.getHeight() && playerShoot.get(i).yPos >= enemy.yPos) {
                point++;
                playerShoot.remove(i);
                explosion = new Explosion(context, enemy.xPos, enemy.yPos);
                explosions.add(explosion);
            }
            else if (playerShoot.get(i).yPos <= 0) {
                playerShoot.remove(i);
            }
        }

        for (int i = 0; i < explosions.size(); i++) {
            canvas.drawBitmap(explosions.get(i).getExplosion(explosions.get(i).frame), explosions.get(i).xPos, explosions.get(i).yPos, null);
            explosions.get(i).frame++;

            if (explosions.get(i).frame > 27) {
                explosions.remove(i);
            }
        }

        if (!pause) {
            handler.postDelayed(runnable, UPDATE_TIME);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (playerShoot.size() < 10) {
                PlayerShoot playerShoot2 = new PlayerShoot(context, player.xPos + player.getWidth() / 2, player.yPos);
                playerShoot.add(playerShoot2);
            }
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            player.xPos = touchX;
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            player.xPos = touchX;
        }

        return true;
    }
}
