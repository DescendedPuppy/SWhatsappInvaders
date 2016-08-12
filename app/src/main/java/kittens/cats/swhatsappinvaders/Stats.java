package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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
    private double bottomscreen;
    private double leftscreen;
    private double rightscreen;

    private String item;

<<<<<<< HEAD
<<<<<<< HEAD
    private Stats(DoubleVector location, double width, double height) {
        super(EntityType.STATS, location);
=======
    private Stats(Context context) {
        super(context, EntityType.STATS, null);
>>>>>>> b5dfedfedc3a1c77d6dd1133bb68367f8b9d56de
=======
    private Stats() {
        player = GameContext.getPlayer();
>>>>>>> 04e2112d90612cdc8f786c04b9e7298fe149c5f3
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
        rightscreen = 50;


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(32.0f);


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


