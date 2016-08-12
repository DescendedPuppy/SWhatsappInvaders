package kittens.cats.swhatsappinvaders.items;

import android.content.Context;

import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public class NukeItem extends Item {
    public NukeItem( Context context, DoubleVector location) {
        super(ItemType.NUKE, context, location);
    }
    @Override
    public void onUse() {

    }
}
