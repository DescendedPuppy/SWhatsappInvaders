package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;

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


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(32.0f);


        canvas.drawText(""+score, (float)halfwidth, (float)topscreen, paint);
        Bitmap bm;
        bm = BitmapFactory.decodeResource(null, R.drawable.spaceship);
        Paint trymypaint;
        trymypaint= new Paint();
        for (int i=0;i<=lives;i++)
        {
            canvas.drawBitmap(bm ,canvas.getWidth()/10+(i*10),canvas.getWidth()/14,trymypaint);
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


