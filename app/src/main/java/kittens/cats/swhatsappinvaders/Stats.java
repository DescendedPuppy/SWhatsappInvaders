package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Ich bin Joris.
 */
public class Stats extends GameObject {

    private static Stats stats;

    private int score;
    private int lives;
    private int kills;

    private double halfwidth;
    private double bottomscreen;
    private double leftscreen;
    private double rightscreen;

    private String item;

    private Stats(DoubleVector location, double width, double height) {
        super(EntityType.STATS, location, width, height);
    }

    public static Stats getStats(DoubleVector location, double width, double height){
        if(Stats.stats == null){
            Stats.stats = new Stats(location, width, height);
        }
        return Stats.stats;
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
    public void setItem(String item){

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
    public String getItem(){

        return this.item;

    }



}


