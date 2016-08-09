package kittens.cats.swhatsappinvaders;


public abstract class GameObject implements Renderable {

    private DoubleVector location;

    public abstract void update();

    public void setLocation(DoubleVector location){

      this.location = location;

    }

    public DoubleVector getLocation() {

        return location;

    }
}
