package kittens.cats.swhatsappinvaders.items;

import android.content.Context;

import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public class HelthItem extends Item{


    public HelthItem(Context context, DoubleVector location) {
        super(ItemType.lIFE, context, location);    }

    @Override
    public void onUse() {
        GameContext.getPlayer().setHealth(GameContext.getPlayer().getHealth() + 1);
    }

}
