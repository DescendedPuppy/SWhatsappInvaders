package kittens.cats.swhatsappinvaders.enemies;


import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public abstract class Enemy extends GameObject {

    private int health = 1;
    private int damage = 1;

    public Enemy(DoubleVector location, double width, double height) {

        super(EntityType.ENEMY, location, width, height);

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
