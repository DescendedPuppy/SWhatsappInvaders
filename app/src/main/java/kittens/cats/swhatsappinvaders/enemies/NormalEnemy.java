package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import kittens.cats.swhatsappinvaders.MainThread;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.util.DoubleVector;


public class NormalEnemy extends Enemy {

    private Bitmap toBeDrawn;

    public NormalEnemy(Context context, DoubleVector location) {
        super(context, location);
        setSpeed(1250);
    }


    @Override
    public void update() {

        super.update();

    }

    @Override
    public void onCollision(kittens.cats.swhatsappinvaders.GameObject other) {

    }


    @Override
    public void render(Canvas canvas) {

        Paint p = new Paint();

        Rect rect = new Rect();
        rect.set((int) getLocation().x, (int) getLocation().y, ((int) getLocation().x + (int) getWidth()), ((int) getLocation().y + (int) getHeight()));

        canvas.drawBitmap(toBeDrawn, null, rect, p);


    }

    @Override
    public void init(int width, int height) {

        int entityWidth = width / 20;
        int entityHeight = height / 15;

        setWidth(entityWidth);
        setHeight(entityHeight);

        toBeDrawn = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.invader_normal);

    }
}
