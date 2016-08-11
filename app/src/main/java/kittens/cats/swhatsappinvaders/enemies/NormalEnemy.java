package kittens.cats.swhatsappinvaders.enemies;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class NormalEnemy extends Enemy {


    public NormalEnemy(DoubleVector location) {
        super(location);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {



        Paint p = new Paint();

        p.setColor(Color.RED);

        canvas.drawRect((float) getLocation().x, (float) getLocation().y, (float) (getLocation().x + getWidth()), (float) (getLocation().y + getHeight()), p);

        p.setColor(Color.YELLOW);


        //canvas.drawRect((float) getLocation().x, (float) getLocation().y,
      //          (float) (canvas.getWidth() - getLocation().x) - (playerwidth / 11), (float) (canvas.getHeight() - getLocation().y) - (playerheight / 8), p);


        //  canvas.drawRect((float) (getLocation().x + getWidth()) + 50, (float) getLocation().y - 50, (float) (getLocation().x + getWidth()) + 50, (float) getLocation().y - 50, p);

    }

    @Override
    public void init(int width, int height) {

        Log.d("NormalEnemy", "Canvas Width: "+width);
        Log.d("NormalEnemy", "Canvas Height: "+height);
        int entityWidth = width / 12;
        int entityHeight = height / 12;

        setWidth(entityWidth);
        setHeight(entityHeight);

    }
}
