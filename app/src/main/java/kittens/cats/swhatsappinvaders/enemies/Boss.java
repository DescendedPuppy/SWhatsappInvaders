package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.MainThread;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class Boss extends Enemy {

    private Bitmap toBeDrawn;


    public Boss(Context context, DoubleVector location) {
        super(context, location);
        setSpeed(750);
    }


    @Override
    public void update() {

        super.update();

    }

    @Override
    public void onCollision(GameObject other) {

    }

    @Override
    public void render(Canvas canvas) {

        Paint p = new Paint();

        p.setColor(Color.WHITE);
        p.setAntiAlias(false);
        p.setDither(true);
        p.setFilterBitmap(false);


        Rect rect = new Rect();
        rect.set((int) getLocation().x, (int) getLocation().y, ((int) getLocation().x + (int) getWidth()), ((int) getLocation().y + (int) getHeight()));

        canvas.drawBitmap(toBeDrawn, null, rect, p);


    }

    @Override
    public void init(int width, int height) {

        tempCanvasWidth = width;

        int entityWidth = width / 3;
        int entityHeight = height / 9;

        setWidth(entityWidth);
        setHeight(entityHeight);

        toBeDrawn = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.invader_boss);

    }

}
