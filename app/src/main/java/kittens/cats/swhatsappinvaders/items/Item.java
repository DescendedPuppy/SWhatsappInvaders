package kittens.cats.swhatsappinvaders.items;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.GamePanel;
import kittens.cats.swhatsappinvaders.MainThread;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.enemies.Enemy;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 10.08.2016.
 */
public abstract class Item extends GameObject{

    private static Bitmap bitmapDoubleItem;

    private ItemType type;

    public Item(ItemType type, Context context, DoubleVector location) {
        super(context, EntityType.ITEM, location);

        this.type = type;
        setSpeed(1000);

    }

    public double unit;

    @Override
    public void init(int width, int height) {
        setHeight(width/11);
        setWidth(width/11);

    }

    @Override
    public void update() {
        this.getLocation().y += this.getSpeed() * MainThread.getDeltaTime() / 1000D;
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawBitmap(this.type.getBitmap(this.getContext()), (float) this.getLocation().x, (float) this.getLocation().y, new Paint());
    }

    @Override
    public void onCollision(GameObject other) {

    }

    public static void handleDeath(Enemy enemy, GamePanel panel) {
        Random random = new Random();
        int randomn;
        randomn = random.nextInt(101);



                if (randomn == 56 || randomn == 21 || randomn == 2 || randomn == 76 || randomn == 43 || randomn == 45)
                {
                    panel.addGameObject(new ShotgunItem(panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));


//shot
                }
                if (randomn == 23 || randomn == 54 || randomn == 42 || randomn == 79 || randomn == 17 || randomn == 5)
                {
                    panel.addGameObject(new ShieldItem(panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
//shi
                }

                if (randomn == 74 || randomn == 69 || randomn == 63 || randomn == 30)
                {
//double
                    panel.addGameObject(new Item(ItemType.DOUBLE, panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
                }

                if (randomn == 92 || randomn == 33 || randomn == 3 || randomn == 44)
                {
//t
                    panel.addGameObject(new Item(ItemType.PAUSE, panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
                }

                if (randomn == 98 || randomn == 21 || randomn == 55 || randomn == 56)
                {
//laser
                    panel.addGameObject(new Item(ItemType.LAZER, panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
                }
                if (randomn == 34 || randomn == 36 || randomn == 96 || randomn == 2)
                {
//l
                    panel.addGameObject(new Item(ItemType.lIFE, panel.getContext(),
                    new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
                }
                if (randomn == 30 || randomn == 8 || randomn == 71)
                {
                    panel.addGameObject(new Item(ItemType.NUKE, panel.getContext(),
                            new DoubleVector(enemy.getLocation().x, enemy.getLocation().y)));
//n
                }

            }

    public abstract void onUse();

        }
