package kittens.cats.swhatsappinvaders;

import android.content.Context;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

public abstract class GameObject implements Renderable {

    private DoubleVector location;
    private EntityType tag;
    private double width;
    private double height;
    private Context context;
    private double speed;


    public abstract void update();



    public GameObject(Context context, EntityType tag, DoubleVector location){

        setTag(tag);
        setLocation(location);
        this.context = context;

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public Context getContext() {
        return context;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public void setLocation(DoubleVector location){

      this.location = location;

    }

    public DoubleVector getLocation() {

        return location;

    }

    public EntityType getType(){

        return this.tag;

    }

    public void setTag(EntityType tag) {
        this.tag = tag;
    }

}
