package kittens.cats.swhatsappinvaders;

public abstract class GameObject implements Renderable {

    private DoubleVector location;
    private EntityType tag;


    public abstract void update();

    public GameObject(EntityType tag){

        this.tag = tag;

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
}
