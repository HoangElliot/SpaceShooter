package com.example.spaceshooter;

import static com.example.spaceshooter.MainMenuActivity.SHARED_PREFERENCES_NAME;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Player {
    Context context;
    Bitmap playerSpaceship;
    boolean alive = true;
    int xPos, yPos, speed;
    Random random;

    Player(Context context) {
        this.context = context;

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        int position = sharedPreferences.getInt("position", 0);

        switch (position){
            case 0:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy1);
                break;
            case 1:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2);
                break;
            case 2:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy3);
                break;
            case 3:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy4);
                break;
            case 4:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy5);
                break;
            case 5:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy6);
                break;
            case 6:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy7);
                break;
            case 7:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy8);
                break;
            case 8:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy9);
                break;
            case 9:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy10);
                break;
            case 10:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy11);
                break;
            case 11:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy12);
                break;
            case 12:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy13);
                break;
            default:
                playerSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy1);
        }

        random = new Random();

        spawn();
    }

    public Bitmap getPlayerSpaceship() {
        return playerSpaceship;
    }

    int getWidth() {
        return playerSpaceship.getWidth();
    }

    int getHeight() {
        return playerSpaceship.getHeight();
    }

    void spawn() {
        xPos = random.nextInt(OnBattle.screenWidth);
        yPos = OnBattle.screenHeight - playerSpaceship.getHeight();

        speed = 10 + random.nextInt(10);
    }
}
