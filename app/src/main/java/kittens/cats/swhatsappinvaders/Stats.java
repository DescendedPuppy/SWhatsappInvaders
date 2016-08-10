package kittens.cats.swhatsappinvaders;

import android.content.ClipData;
import android.graphics.Canvas;

/**
 * Ich bin Joris.
 */
public class Stats extends GameObject {

    public int score;
    public int lives;
    public int kills;

    ClipData.Item item;

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas) {

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


