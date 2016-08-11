package kittens.cats.swhatsappinvaders;

import kittens.cats.swhatsappinvaders.player.Player;

/**
 * Ich bin Joris.
 */
public class GameContext {

    private static Player player;



    public static void setPlayer(Player playerObject){
        player = playerObject;
    }


    public static Player getPlayer(){

        return player;

    }

}
