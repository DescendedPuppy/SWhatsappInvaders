package kittens.cats.swhatsappinvaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

<<<<<<< HEAD
import kittens.cats.swhatsappinvaders.items.Item;
=======
import kittens.cats.swhatsappinvaders.enemies.NormalEnemy;
import kittens.cats.swhatsappinvaders.items.Item;
import kittens.cats.swhatsappinvaders.player.Player;
>>>>>>> b5dfedfedc3a1c77d6dd1133bb68367f8b9d56de
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        GamePanel panel = new GamePanel(this);
        this.setContentView(panel);
        panel.addGameObject(new Item(new DoubleVector(56, 56)) {
            @Override
            public void update() {

            }
        });
=======
        GamePanel panel = new GamePanel(new Player(this, 10), this);
        panel.addGameObject(new NormalEnemy(this, new DoubleVector(500, 500)));
        panel.addGameObject(Stats.getStats(this));
        this.setContentView(panel);





>>>>>>> b5dfedfedc3a1c77d6dd1133bb68367f8b9d56de
    }
}
