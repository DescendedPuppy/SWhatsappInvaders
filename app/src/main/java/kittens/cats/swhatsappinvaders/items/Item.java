package kittens.cats.swhatsappinvaders.items;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 10.08.2016.
 */
public abstract class Item extends GameObject{


    public Item(DoubleVector location) {
        super(EntityType.ITEM, location);
    }

    public double unit;

    @Override
    public void render(Canvas canvas) {
        unit = canvas.getWidth();

        Paint trymypaint;
        trymypaint= new Paint();
        trymypaint.setColor(Color.WHITE);

        canvas.drawRect((float)unit, (float)(2 * unit), (float)(4 * unit), (float)(20 * unit), trymypaint);
        canvas.drawRect((float)(2 * unit),(float) unit,(float) (8 * unit),(float) (19 * unit), trymypaint);
        canvas.drawRect((float)(5 * unit),(float) unit ,(float)(5 * unit),(float) (19 * unit), trymypaint);
        canvas.drawRect((float)(3 * unit),(float) (4 * unit),(float) (6 * unit),(float) (18 * unit), trymypaint);
        canvas.drawRect((float)(4 * unit),(float) (6 * unit),(float) (7 * unit),(float) (17 * unit), trymypaint);

        /*canvas.drawRect(canvas.getWidth()/13,canvas.getWidth()/10,canvas.getWidth()/10,canvas.getWidth()/13,trymypaint);
        canvas.drawRect(canvas.getWidth()/10,canvas.getWidth()/12,canvas.getWidth()/8,canvas.getWidth()/14,trymypaint);
        canvas.drawRect(canvas.getWidth()/12,canvas.getWidth()/8,canvas.getWidth()/14,canvas.getWidth()/10,trymypaint);*/

    }
}
