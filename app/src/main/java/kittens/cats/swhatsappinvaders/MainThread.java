package kittens.cats.swhatsappinvaders;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private static long deltaTime;

    public static final String TAG = "MainThread";

    public static final int MAX_FPS = 30;
    public static final long TARGET_TIME = 1000 / 30;

    private boolean running;
    private SurfaceHolder holder;
    private GamePanel panel;
    private double averageFps;

    public MainThread(GamePanel panel) {
        this.panel = panel;
        this.holder = panel.getHolder();

        this.running = true;
        this.averageFps = 0D;
    }

    @Override
    public void run() {
        long startTime;
        long timeDiff;
        long frameCounter = 0;
        long totalTime = 0;

        for (GameObject object : this.panel.getObjects()) {
            object.init(this.panel.getWidth(), this.panel.getHeight());
        }
        this.panel.getPlayer().init(this.panel.getWidth(), this.panel.getHeight());

        while (this.isRunning()) {
            startTime = System.currentTimeMillis();
            Canvas canvas = null;
            try {
                canvas = this.holder.lockCanvas();

                synchronized (this.panel) {
                    this.panel.render(canvas);
                    this.panel.update();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        this.holder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            MainThread.deltaTime = System.currentTimeMillis() - startTime;
            timeDiff = MainThread.TARGET_TIME - MainThread.deltaTime;

            try {
                if (timeDiff > 0) {
                    Thread.sleep(timeDiff);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            frameCounter++;
            totalTime += System.currentTimeMillis() - startTime;

            if (frameCounter >= MainThread.MAX_FPS) {
                this.averageFps = 1000D / ((totalTime / frameCounter) / 1000D);

                frameCounter = 0;
                totalTime = 0;

                Log.d(MainThread.TAG, "Average FPS: " +  this.averageFps);
            }
        }
    }

    public static long getDeltaTime() {
        return deltaTime;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
