package kittens.cats.swhatsappinvaders.enemies;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;


import kittens.cats.swhatsappinvaders.MainActivity;
import kittens.cats.swhatsappinvaders.R;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class NormalEnemy extends Enemy {


    public NormalEnemy(Context context, DoubleVector location) {
        super(context, location);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.GREEN);

        Bitmap invaderNormal = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.invader_normal);

        Rect rect = new Rect();
        rect.set((int) getLocation().x, (int) getLocation().y, ((int) getLocation().x + (int) getWidth()), ((int) getLocation().y + (int) getHeight()));

        canvas.drawBitmap(invaderNormal, null, rect, p);


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
