package kittens.cats.swhatsappinvaders.enemies;


import kittens.cats.swhatsappinvaders.DoubleVector;
import kittens.cats.swhatsappinvaders.EntityType;
import kittens.cats.swhatsappinvaders.GameObject;

public abstract class Enemy extends GameObject {

    private int health;
    private int damage;

    public Enemy(EntityType tag, DoubleVector location, double width, double height, int damage, int health) {

        super(tag, location, width, height);
        setDamage(damage);
        setHealth(health);

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
