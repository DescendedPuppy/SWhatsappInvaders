package kittens.cats.swhatsappinvaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kittens.cats.swhatsappinvaders.enemies.NormalEnemy;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GamePanel panel = new GamePanel(this);
        panel.addGameObject(new NormalEnemy(this, new DoubleVector(500, 500)));

        this.setContentView(panel);



    }
}
