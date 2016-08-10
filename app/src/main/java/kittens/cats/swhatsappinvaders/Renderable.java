package kittens.cats.swhatsappinvaders;

import android.graphics.Canvas;

public interface Renderable {

    void render(Canvas canvas);

    void init(int width, int height);

}
