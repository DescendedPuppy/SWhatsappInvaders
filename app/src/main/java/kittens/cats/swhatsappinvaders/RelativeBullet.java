package kittens.cats.swhatsappinvaders;

import android.content.Context;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class RelativeBullet extends Bullet {

    private GameObject relativeTo;
    private double offsetToRight;

    public RelativeBullet(double offsetToRight, int damage, double angle, float speed, Context context, GameObject relativeTo) {
        super(damage, angle, speed, context, new DoubleVector(0, 0));
        this.relativeTo = relativeTo;
        this.offsetToRight = offsetToRight;
    }

    @Override
    public void init(int width, int height) {
        super.init(width, height);

        this.getLocation().x = this.relativeTo.getLocation().x
                + this.relativeTo.getWidth() / 2D + this.getWidth() / 2D + this.offsetToRight;
        this.getLocation().y = this.relativeTo.getLocation().y;
    }
}
