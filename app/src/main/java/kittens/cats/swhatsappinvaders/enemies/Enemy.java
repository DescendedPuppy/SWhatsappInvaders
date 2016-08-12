package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;
import android.util.Log;

import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.MainThread;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public abstract class Enemy extends GameObject {

    private int health = 1;
    private int damage = 1;
    protected int tempCanvasWidth;

    public Enemy(Context context, DoubleVector location) {

        super(context, EntityType.ENEMY, location);

    }


    public void doDamage(int damage){

        setHealth(getHealth() - damage);

    }

    @Override
    public void update() {

        if(getLocation().x <= 0 || getLocation().x >= tempCanvasWidth - getWidth()){
        Log.d("Enemy", "Loc X: "+getLocation().x+" | TempCanvWidth: "+tempCanvasWidth+" | Width: "+getWidth());
            setSpeed(getSpeed() * -1);

            if(getLocation().x <= 0)
                setLocation(new DoubleVector(1, getLocation().y + getHeight()));
            else if(getLocation().x >= tempCanvasWidth - getWidth())
                setLocation(new DoubleVector(tempCanvasWidth - getWidth() - 3, getLocation().y + getHeight()));


        }

        setLocation(new DoubleVector(getLocation().x + (getSpeed() / 1000) * MainThread.getDeltaTime(), getLocation().y));



    }

    @Override
    public void init(int width, int height) {

        tempCanvasWidth = width;


    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
