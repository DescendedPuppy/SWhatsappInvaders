package kittens.cats.swhatsappinvaders.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.BulletSpan;
import android.util.Log;

import kittens.cats.swhatsappinvaders.Bullet;
import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.player.shotmethods.DefaultShotMethod;
import kittens.cats.swhatsappinvaders.player.shotmethods.ShotgunShotMethod;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class Player extends GameObject {

    private Bitmap spaceshipBitmap;
    private int health;
    private boolean holdDown = false;

    private long shootDelta = 300;
    private long lastShot = 0;
    private int shotAmount = 10;

    private ShotMethod shotMethod;

    public Player(Context context, int health) {
        super(context, EntityType.PLAYER, new DoubleVector(0, 0));
        this.health = health;
        this.enableDefaultMode();
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
        if (this.isHoldDown() && System.currentTimeMillis() - lastShot >= this.shootDelta) {
            lastShot = System.currentTimeMillis();
            this.getShotMethod().shoot();
        }
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
        if (this.health <= 4) {
            this.health = health;
        }
    }

    public int damageAndGet(int amount) {
        return this.health -= amount;
    }

    public void setHoldDown(boolean holdDown) {
        this.holdDown = holdDown;
    }

    public boolean isHoldDown() {
        return holdDown;
    }

    public void setShotAmount(int shotAmount) {
        this.shotAmount = shotAmount;
    }

    public int getShotAmount() {
        return shotAmount;
    }

    public void setShotMethod(ShotMethod shotMethod) {
        this.shotMethod = shotMethod;
    }

    public ShotMethod getShotMethod() {
        return shotMethod;
    }

    public void enableShotgunMode() {
        this.setShotMethod(new ShotgunShotMethod(this));
    }

    public void enableDefaultMode() {
        this.setShotMethod(new DefaultShotMethod(this));
    }

}
