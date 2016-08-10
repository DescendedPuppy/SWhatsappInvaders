package kittens.cats.swhatsappinvaders.enemies;


import kittens.cats.swhatsappinvaders.GameObject;

public abstract class Enemy extends GameObject {

    private int health;
    private int damage;

    public Enemy(int health, int damage){

        setHealth(health);
        setDamage(damage);

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
