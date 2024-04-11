package com.example.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class EnemyShoot {
    Bitmap shoot;
    Context context;
    int xPos, yPos;

    public EnemyShoot(Context context, int xPos, int yPos) {
        this.context = context;
        shoot = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);

        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Bitmap getShoot() {
        return shoot;
    }
}
