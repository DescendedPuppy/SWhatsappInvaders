package kittens.cats.swhatsappinvaders;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

public abstract class GameObject implements Renderable {

    private DoubleVector location;
    private EntityType tag;
    private double width;
    private double height;



    public abstract void update();



    public GameObject(EntityType tag, DoubleVector location, double width, double height){

        setTag(tag);
        setHeight(height);
        setWidth(width);
        setLocation(location);

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

    public boolean collisionCheck (GameObject other) {

        if (Math.abs(2*((this.location.y - other.location.y) + (this.height - other.height))) < this.height + other.height) {
            if (Math.abs(2*((this.location.x - other.location.x) + (this.width - other.width))) < this.width + other.width) {
                onCollision(other);
                return true;
            }
        }
        return false;
    }

    public abstract void onCollision (GameObject other);
}
