package kittens.cats.swhatsappinvaders.items;

import android.content.Context;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public class Pauseitem extends Item {
    public Pauseitem ( Context context, DoubleVector location) {
        super(ItemType.PAUSE, context, location);
    }
    @Override
    public void onUse() {



    }
}

