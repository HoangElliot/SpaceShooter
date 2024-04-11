package com.example.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Explosion  {
    Bitmap explosion[] = new Bitmap[28];
    int frame, xPos, yPos;

    public Explosion(Context context, int xPos, int yPos) {
        explosion[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e1);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e2);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e3);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e4);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e5);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e6);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e7);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e8);
        explosion[8] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e1);
        explosion[9] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e9);
        explosion[10] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e10);
        explosion[11] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e11);
        explosion[12] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e12);
        explosion[13] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e13);
        explosion[14] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e14);
        explosion[15] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e15);
        explosion[16] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e16);
        explosion[17] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e17);
        explosion[18] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e18);
        explosion[19] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e19);
        explosion[20] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e20);
        explosion[21] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e21);
        explosion[22] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e22);
        explosion[23] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e23);
        explosion[24] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e24);
        explosion[25] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e25);
        explosion[26] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e26);
        explosion[27] = BitmapFactory.decodeResource(context.getResources(), R.drawable.e27);

        frame = 0;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Bitmap getExplosion(int frame) {
        return explosion[frame];
    }

}
