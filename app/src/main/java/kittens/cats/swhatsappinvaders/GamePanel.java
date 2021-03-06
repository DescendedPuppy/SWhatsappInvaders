package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.graphics.Canvas;
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
        GameContext.setPlayer(player);
        this.stats = Stats.getStats();

        this.getHolder().addCallback(this);

        GameContext.setGamePanel(this);
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

    private float touchStart;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.touchStart = event.getX();
                this.player.setHoldDown(true);
                break;
            case MotionEvent.ACTION_MOVE:
                float touchDelta = event.getX() - this.touchStart;
                double newX = this.player.getLocation().x + touchDelta;
                if (newX >= 0 && newX + this.player.getWidth() <= this.getWidth()) {
                    this.player.getLocation().x = newX;
                }
                this.touchStart = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                this.player.setHoldDown(false);
                break;
        }
        return true;
    }

    private void movePlayerTo(double pos) {
        if (pos + this.player.getWidth() < this.getWidth()) {
            this.player.getLocation().x = pos;
        }
    }

    public void update() {
        List<GameObject> objectsCopy = new ArrayList<>(this.objects);
        for (GameObject object : objectsCopy) {
            object.update();
            if (!object.isWithinBorders()) {
                this.removeGameObject(object);
            }
            if (object instanceof Enemy) {
                Enemy enemy = (Enemy) object;
                if (enemy.getHealth() <= 0) {
                    this.removeGameObject(enemy);
                    Item.handleDeath(enemy, this);
                }
            }
            for (GameObject colliding : this.objects) {
                object.collisionCheck(colliding);
            }
            if (this.player.collisionCheck(object)) {
                object.onCollision(this.player);
            }
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
        this.stats.render(canvas);
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
