package kittens.cats.swhatsappinvaders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kittens.cats.swhatsappinvaders.items.Item;
import kittens.cats.swhatsappinvaders.util.DoubleVector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GamePanel panel = new GamePanel(this);
        this.setContentView(panel);
        panel.addGameObject(new Item(new DoubleVector(56, 56)) {
            @Override
            public void update() {

            }
        });
    }
}
