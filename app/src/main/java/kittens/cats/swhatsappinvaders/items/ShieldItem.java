package kittens.cats.swhatsappinvaders.items;

import android.content.Context;

import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.player.Player;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public class ShieldItem extends Item {
    public ShieldItem( Context context, DoubleVector location) {
        super(ItemType.SHIELD, context, location);
    }
    @Override
    public void onUse() {
        GameContext.getPlayer().setShield(true);
    }
}
