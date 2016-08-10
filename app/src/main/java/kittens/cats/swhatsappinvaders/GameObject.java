package kittens.cats.swhatsappinvaders;

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

}
