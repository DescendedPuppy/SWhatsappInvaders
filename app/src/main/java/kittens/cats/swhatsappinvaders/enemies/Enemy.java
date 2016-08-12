package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;

import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public abstract class Enemy extends GameObject {

    private int health = 1;
    private int damage = 1;

    public Enemy(Context context, DoubleVector location) {

        super(context, EntityType.ENEMY, location);

    }


    public void doDamage(int damage){

<<<<<<< HEAD
        super(EntityType.ENEMY, location);
=======
        setHealth(getHealth() - damage);
>>>>>>> b5dfedfedc3a1c77d6dd1133bb68367f8b9d56de

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
