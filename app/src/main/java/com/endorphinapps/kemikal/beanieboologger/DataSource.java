package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/09/2016.
 */

public class DataSource {

    private List<Item> items;

    public DataSource() {
        this.items = new ArrayList<>();

        items.add(new Item("Barley the Dog", R.drawable.barley_dog));
        items.add(new Item("Coconut the Monkey", R.drawable.coconut_monkey));
        items.add(new Item("Dotty the Leopard", R.drawable.dotty_leopard));
        items.add(new Item("Icy the Seal", R.drawable.icy_seal));
        items.add(new Item("Kiki the Cat", R.drawable.kiki_cat));
        items.add(new Item("Leona the Leopard", R.drawable.leona_leopard));
        items.add(new Item("Muffin the Cat", R.drawable.muffin_cat));
        items.add(new Item("Patsy the Poodle", R.drawable.patsy_poodle));
        items.add(new Item("Pegasus the Unicorn", R.drawable.pegasus_unicorn));
        items.add(new Item("Piggly the Pig", R.drawable.piggly_pig));
        items.add(new Item("Scarem the Bat", R.drawable.scarem_bat));
        items.add(new Item("Scooter the Snail", R.drawable.scooter_snail));
        items.add(new Item("Slick the Fox", R.drawable.slick_fox));
        items.add(new Item("Slushy the Husky", R.drawable.slushy_husky));
        items.add(new Item("Squeaker the Mouse", R.drawable.squeaker_mouse));
        items.add(new Item("Tracy the Dog", R.drawable.tracy_dog));
        items.add(new Item("Whiskers the Shnauzer", R.drawable.whiskers_shnauzer));
    }

    public List<Item> getItems() {
        return items;
    }
}
