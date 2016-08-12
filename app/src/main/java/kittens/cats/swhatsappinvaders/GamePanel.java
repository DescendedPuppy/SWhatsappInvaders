package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import kittens.cats.swhatsappinvaders.enemies.Enemy;
import kittens.cats.swhatsappinvaders.items.Item;
import kittens.cats.swhatsappinvaders.player.Player;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private Player player;
    private MainThread thread;
    private List<GameObject> objects;
    private Stats stats;
    
    public GamePanel(Player player, Context context) {
        super(context);

        this.player = player;
        this.objects = new ArrayList<>();

        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.thread = new MainThread(this);
        this.thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean running = true;

        while (running) {
            try {
                this.thread.setRunning(false);
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            running = false;
        }
    }

    float touchX = -1;
    float touchY = -1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.player.getLocation().x = touchX;
                break;
            case MotionEvent.ACTION_MOVE:
                this.player.getLocation().x = touchX;
                break;
            case MotionEvent.ACTION_UP:
                this.player.getLocation().x = touchX;
                break;
        }
        return true;
    }

    public void update() {
        List<GameObject> objectsCopy = new ArrayList<>(this.objects);
        for (GameObject object : objectsCopy) {
            object.update();
            if (object instanceof Enemy) {
                Enemy enemy = (Enemy) object;
                if (enemy.getHealth() <= 0) {
                    Item.handleDeath(enemy, this);
                }
            }
        }
        if (this.stats != null) {
            this.stats.update();
        }
        if (this.player != null) {
            this.player.update();
        }
    }

    public void render(Canvas canvas) {
        this.draw(canvas);
        for (GameObject object : this.objects) {
            object.render(canvas);
        }
        if (this.stats != null) {
            this.stats.render(canvas);
        }
        if (this.player != null) {
            this.player.render(canvas);
        }
    }

    public void addGameObject(GameObject object) {
        object.init(this.getHeight(), this.getWidth());
        this.objects.add(object);
    }

    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Player getPlayer() {
        return player;
    }

}
