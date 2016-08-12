package kittens.cats.swhatsappinvaders.player.shotmethods;

import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.player.Player;
import kittens.cats.swhatsappinvaders.RelativeBullet;
import kittens.cats.swhatsappinvaders.player.ShotMethod;

public class DefaultShotMethod implements ShotMethod {

    private Player player;
    private double shotAmount;

    public DefaultShotMethod(Player player) {
        this.player = player;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < this.player.getShotAmount(); i++) {
            GameContext.getGamePanel().addGameObject(
                    new RelativeBullet((i - this.player.getShotAmount() / 2) * 20, 10, 90, 4000,
                            this.player.getContext(), this.player)
            );
        }
    }
}
