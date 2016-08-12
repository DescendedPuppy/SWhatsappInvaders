package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.content.Entity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by sebagreg16 on 10.08.2016.
 */
public class Bullet extends GameObject{

    private float speed;
    private int color;
    private int dmg;
    private double angleCosinus;
    private double angleSinus;
    private double shotSize = 100;

    public Bullet (int damage, double angle, float speed, Context context, DoubleVector location) {
        super(context, EntityType.BULLET, location);
        this.speed = speed;
        this.angleCosinus = Math.cos(Math.toRadians(angle));
        this.angleSinus = Math.sin(Math.toRadians(angle));
        color = Color.WHITE;
        dmg = damage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public void update() {
        double radius = this.speed * MainThread.getDeltaTime() / 1000D;

        this.setLocation(new DoubleVector(this.getLocation().x + angleCosinus * radius,
                this.getLocation().y - angleSinus * radius));
    }

    @Override
    public void onCollision(GameObject other) {

    }

    @Override
    public void render(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(10F);

        canvas.drawLine((float) this.getLocation().x, (float) this.getLocation().y,
                (float) (this.getLocation().x + this.angleCosinus * this.getShotSize()),
                (float) (this.getLocation().y - this.angleSinus * this.getShotSize()), paint);

    }

    @Override
    public void init(int width, int height) {
        this.setWidth(this.angleCosinus * this.getShotSize());
        this.setHeight(this.angleSinus * this.getShotSize());
    }

    public double getShotSize() {
        return shotSize;
    }

}
