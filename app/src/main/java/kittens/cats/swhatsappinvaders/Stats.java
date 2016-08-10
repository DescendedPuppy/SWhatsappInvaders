package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Ich bin Joris.
 */
public class Stats extends GameObject {

    public int score;
    public int lives;
    public int kills;

    public double halfwidth;
    public double bottomscreen;
    public double leftscreen;
    public double rightscreen;

    Item item;

    public Stats(EntityType tag, DoubleVector location, double width, double height) {
        super(tag, location, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {

        halfwidth = canvas.getWidth() / 2;
        bottomscreen = canvas.getHeight() - 50;
        rightscreen = 50;


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);


        canvas.drawText(""+score, (float)halfwidth, (float)bottomscreen, paint);
        canvas.drawText(""+lives, (float)rightscreen, (float)bottomscreen, paint);

    }

    //SETTERS
    public void setScore(int score){

        this.score = score;

    }
    public void setLives(int lives){

        this.lives = lives;

    }
    public void setKills(int kills){

        this.kills = kills;

    }
    public void setItem(Item item){

        this.item = item;

    }

    //GETTERS
    public int getScore(){

        return this.score;

    }
    public int getLives(){

        return this.lives;

    }
    public int getKills(){

        return this.kills;

    }
    public Item getItem(){

        return this.item;

    }



}


