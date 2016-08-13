package kittens.cats.swhatsappinvaders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import kittens.cats.swhatsappinvaders.player.Player;

/**
 * Ich bin Joris.
 */
public class Stats{

    private static Stats stats;

    private Player player;

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
        int score = 100000; // TODO: get score from elsewhere

        int health = this.player.getHealth();

        double halfWidth = canvas.getWidth() / 2;
        double topOffset = canvas.getHeight() / 75;

        // Score

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(50F);

        canvas.drawText(String.valueOf(score), (float) halfWidth, (float) topOffset + 50, textPaint);


        Bitmap bm = BitmapFactory.decodeResource(
                GameContext.getGamePanel().getResources(), R.drawable.spaceship
        );

        Rect healthContainer = new Rect();
        Paint healthPaint = new Paint();

        for (int i = 0; i <= health; i++) {
            healthContainer.set(i * 50 + 10, (int) topOffset, i * 50 + 50, (int) topOffset + 50);
            canvas.drawBitmap(bm, null, healthContainer, healthPaint);
        }

    }

}


