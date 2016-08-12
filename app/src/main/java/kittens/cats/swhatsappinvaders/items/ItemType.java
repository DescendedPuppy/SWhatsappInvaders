package kittens.cats.swhatsappinvaders.items;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import kittens.cats.swhatsappinvaders.R;

/**
 * Created by guidsmel16 on 11.08.2016.
 */
public enum ItemType {

    DOUBLE(R.drawable.item_double),
    LAZER(R.drawable.item_lazer),
    NUKE(R.drawable.item_nuke),
    PAUSE(R.drawable.item_pause),
    SHIELD(R.drawable.item_shield),
    lIFE(R.drawable.item_life),
    SHOTGUN(R.drawable.item_shotgun);

    private int id;
    private Bitmap bitmap;

    ItemType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Bitmap getBitmap(Context context) {
        if (this.bitmap == null) {
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), this.id);
        }
        return this.bitmap;
    }

}
