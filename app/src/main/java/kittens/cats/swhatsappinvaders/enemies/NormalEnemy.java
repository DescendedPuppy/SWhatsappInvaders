package kittens.cats.swhatsappinvaders.enemies;


import android.graphics.Canvas;

import kittens.cats.swhatsappinvaders.DoubleVector;
import kittens.cats.swhatsappinvaders.EntityType;

public class NormalEnemy extends Enemy {


    public NormalEnemy(EntityType tag, DoubleVector location, double width, double height, int damage, int health) {
        super(tag, location, width, height, damage, health);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {

    }
}
