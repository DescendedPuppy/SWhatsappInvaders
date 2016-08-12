package kittens.cats.swhatsappinvaders.player.shotmethods;

import kittens.cats.swhatsappinvaders.GameContext;
import kittens.cats.swhatsappinvaders.player.Player;
import kittens.cats.swhatsappinvaders.RelativeBullet;
import kittens.cats.swhatsappinvaders.player.ShotMethod;

public class ShotgunShotMethod implements ShotMethod {

    private Player player;
    private double degreeOffset = 50;

    public ShotgunShotMethod(Player player) {
        this.player = player;
    }

    @Override
    public void shoot() {
        double anglePerShot = (180D - 2 * this.degreeOffset) / (this.player.getShotAmount() + 1);

        for (int i = 1; i <= this.player.getShotAmount(); i++) {
            double angle = anglePerShot * i + this.degreeOffset;

            GameContext.getGamePanel().addGameObject(
                    new RelativeBullet(0, 10, angle, 4000, this.player.getContext(), this.player)
            );
        }
    }

    public Player getPlayer() {
        return player;
    }

}
