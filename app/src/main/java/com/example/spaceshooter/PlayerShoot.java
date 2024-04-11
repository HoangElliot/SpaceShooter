package com.example.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PlayerShoot {
    Bitmap shoot;
    Context context;
    int xPos, yPos;

    public PlayerShoot(Context context, int xPos, int yPos) {
        this.context = context;
        shoot = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet3);

        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Bitmap getShoot() {
        return shoot;
    }
}
