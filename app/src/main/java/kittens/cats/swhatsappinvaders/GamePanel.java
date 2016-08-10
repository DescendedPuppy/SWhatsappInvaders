package kittens.cats.swhatsappinvaders;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private List<GameObject> objects;
    private Stats stats;

    public GamePanel(Context context) {
        super(context);

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

    public void update() {
        for (GameObject object : this.objects) {
            object.update();
        }
        this.stats.update();
    }

    public void render(Canvas canvas) {
        this.draw(canvas);
        for (GameObject object : this.objects) {
            object.render(canvas);
        }
        this.stats.render(canvas);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

}
