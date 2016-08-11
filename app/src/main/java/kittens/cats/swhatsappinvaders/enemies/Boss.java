package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class Boss extends Enemy {

    private Bitmap toBeDrawn;

    public Boss(Context context, DoubleVector location) {
        super(context, location);
    }

    @Override
    public void update() {

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

        int entityWidth = width / 4;
        int entityHeight = height / 10;

        setWidth(entityWidth);
        setHeight(entityHeight);

        toBeDrawn = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.invader_boss);

    }
}
