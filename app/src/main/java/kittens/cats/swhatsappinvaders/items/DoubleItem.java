package kittens.cats.swhatsappinvaders.items;

import android.content.Context;

import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public class DoubleItem extends Item {
    public DoubleItem(Context context, DoubleVector location) {
        super(ItemType.DOUBLE, context, location);
    }

    @Override
    public void onUse() {

        GameContext.getPlayer().enableDefaultMode();
        GameContext.getPlayer().setShotAmount(GameContext.getPlayer().getShotAmount()+1);
    }
}
