package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by sebagreg16 on 11.08.2016.
 */
public class House extends GameObject {
    Bitmap[] houseSprites;
    int healthHouse = 0;
    Bitmap currentHouse;

    public House(Context context, DoubleVector location) {
        super(context, EntityType.HOUSE, location);
        houseSprites = new Bitmap[7];
        houseSprites[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home1);
        houseSprites[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home2);
        houseSprites[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home3);
        houseSprites[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home4);
        houseSprites[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home5);
        houseSprites[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home6);
        houseSprites[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.invaders_home7);
        currentHouse = houseSprites[0];
    }

    @Override
    public void update() {

    }

    @Override
    public void onCollision(GameObject other) {
        currentHouse = houseSprites[healthHouse +1];
    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint(); Rect rect = new Rect();
        rect.set((int) getLocation().x, (int) getLocation().y, ((int) getLocation().x + (int) getWidth()), ((int) getLocation().y + (int) getHeight()));

        canvas.drawBitmap(currentHouse, null, rect, paint);

    }

    @Override
    public void init(int width, int height) {
        this.setHeight(height / 12);
        this.setWidth(width / 6);
    }
}
