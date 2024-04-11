package com.example.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {
    Context context;
    Bitmap enemySpaceship;
    int xPos, yPos, speed;
    Random random;

    Enemy(Context context) {
        this.context = context;
        enemySpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.player10);
        random = new Random();

        spawnEnemy();
    }

    Bitmap getEnemySpaceship() {
        return enemySpaceship;
    }

    int getWidth() {
        return enemySpaceship.getWidth();
    }

    int getHeight() {
        return enemySpaceship.getHeight();
    }

    void spawnEnemy() {
        xPos = random.nextInt(720);
        yPos = 50;

        speed = 10 + random.nextInt(10);
    }
}
