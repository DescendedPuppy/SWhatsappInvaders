package kittens.cats.swhatsappinvaders.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class Player extends GameObject {

    private Bitmap spaceshipBitmap;
    private int health;

    public Player(Context context, int health) {
        super(context, EntityType.PLAYER, new DoubleVector(0, 0));
        this.health = health;
    }

    @Override
    public void init(int width, int height) {
        this.spaceshipBitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.spaceship);

        this.setWidth(width / 9);
        this.setHeight(width / 9);
        this.getLocation().y = height - this.getHeight();
        this.getLocation().x = width / 2D - this.getWidth() / 2D;
    }

    @Override
    public void update() {
    }

    @Override
    public void onCollision(GameObject other) {

    }


    @Override

    public void render(Canvas canvas) {
        Rect rect = new Rect((int) this.getLocation().x, (int) this.getLocation().y,
                (int) (this.getLocation().x + this.getWidth()),
                (int) (this.getLocation().y + this.getHeight()));
        canvas.drawBitmap(this.spaceshipBitmap, null, rect, new Paint());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int damageAndGet(int amount) {
        return this.health -= amount;
    }

}
