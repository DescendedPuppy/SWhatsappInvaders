package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;

import kittens.cats.swhatsappinvaders.player.Player;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Ich bin Joris.
 */
public class Stats{

    private static Stats stats;

    private Player player;

    private int score = 10000;
    private int lives;
    private int kills;
    private double bettertopscreen;

    private double halfwidth;
    private double bottomscreen,topscreen;
    private double leftscreen;
    private double rightscreen;

    private String item;

    private Stats() {
        player = GameContext.getPlayer();
    }

    public static Stats getStats(){
        if(Stats.stats == null){
            Stats.stats = new Stats();
        }
        return Stats.stats;
    }







    public void render(Canvas canvas) {

        lives = player.getHealth();

        halfwidth = canvas.getWidth() / 2;
        bottomscreen = canvas.getHeight() - 50;
        topscreen = canvas.getHeight()/25;
        rightscreen = 50;
        bettertopscreen = 50;


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50.0f);


        canvas.drawText(""+score, (float)halfwidth, (float)topscreen, paint);
        Bitmap bm;
        bm = BitmapFactory.decodeResource(GameContext.getGamePanel().getResources(), R.drawable.spaceship);
        Paint trymypaint;
        Rect rekt;
        rekt = new Rect();
        trymypaint= new Paint();

        for (int i=0;i<=lives;i++)
        {
            rekt.set(i*50+10, (int)Math.ceil(bettertopscreen), i*50+50, (int)Math.ceil(bettertopscreen)+50);
            canvas.drawBitmap(bm, null, rekt, trymypaint);
        }

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


