package kittens.cats.swhatsappinvaders;

import kittens.cats.swhatsappinvaders.player.Player;

/**
 * Ich bin Joris.
 */
public class GameContext {

    private static Player player;

    private static GamePanel gamePanel;


    public static void setPlayer(Player playerObject){
        player = playerObject;
    }


    public static void setGamePanel(GamePanel panel) {
        GameContext.gamePanel = panel;
    }


    public static Player getPlayer() {

        return player;

    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

}
