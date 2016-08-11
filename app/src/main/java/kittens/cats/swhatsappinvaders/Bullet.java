package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.content.Entity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by sebagreg16 on 10.08.2016.
 */
public class Bullet extends GameObject{
    private float speedX;
    private float speedY;
    private int color;
    private double dmg;

    public Bullet (Context context, DoubleVector location){
        super(context, EntityType.BULLET, location);
        speedX = 0;
        speedY = 20;
        color = Color.WHITE;
        dmg = 100;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    @Override
    public void update() {
        getLocation().x += speedX * MainThread.getDeltaTime() / 1000D;
        getLocation().y += speedY * MainThread.getDeltaTime() / 1000D;


    }

    @Override
    public void onCollision(GameObject other) {

    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect((float)getLocation().x, (float)getLocation().y, (float)(getLocation().x + getWidth()), (float)(getLocation().y + getHeight()), paint);

    }

    @Override
    public void init(int width, int height) {
        this.setWidth(width / 100);
        this.setHeight(width / 20);
    }
}
