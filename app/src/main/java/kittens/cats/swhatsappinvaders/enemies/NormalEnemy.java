package kittens.cats.swhatsappinvaders.enemies;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class NormalEnemy extends Enemy {


    public NormalEnemy(DoubleVector location, double width, double height) {
        super(location, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.RED);
        canvas.drawRect((float) getLocation().x, (float) getLocation().y, (float) getWidth(), (float) getHeight(), p);



    }
}
