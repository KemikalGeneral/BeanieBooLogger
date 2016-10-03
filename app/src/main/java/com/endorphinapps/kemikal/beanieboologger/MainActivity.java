package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private MyArrayAdapter myArrayAdapter;
    private MyCursorAdapter myCursorAdapter;
    private DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all views
        findViews();

        //Setup Database from DBHelper Class
        DBHelper db = new DBHelper(this);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(db.getDatabaseName(), MODE_PRIVATE, null, null);
        //TEMP drop table for clean rebuild
        db.deleteTable(sqLiteDatabase);
        //Create Database
        db.onCreate(sqLiteDatabase);
        //Add all Beanies
        addAllBeanies(db);
        //Select all Beanies
        ArrayList list = db.selectAllWithArray();
        //Setup and add adapter
        myArrayAdapter = new MyArrayAdapter(this);
        myArrayAdapter.addAll(db.selectAllWithArray());
        gridView.setAdapter(myArrayAdapter);

        Log.v("z! DB", list.toString());
    }

    private void findViews() {
        gridView = (GridView) findViewById(R.id.grid_view);
    }

    private void addAllBeanies(DBHelper db) {
        db.insert("Alpine Red Horns", R.drawable.alpine_red_horns);//Duplicated as the first one is missing???
        db.insert("AlpineRedHorns", R.drawable.alpine_red_horns);
        db.insert("Barley Dog", R.drawable.barley_dog);
        db.insert("Buckwheat the Lynx", R.drawable.buckwheat_lynx);
        db.insert("Cinder the Dragon", R.drawable.cinder_dragon);
        db.insert("Coconut Monkey", R.drawable.coconut_monkey);
        db.insert("Dotty Leopard", R.drawable.dotty_leopard);
        db.insert("Dougie the Dog", R.drawable.dougie_dog);
        db.insert("Duke the Dog", R.drawable.duke_dog);
        db.insert("Fantasia the Unicorn", R.drawable.fantasia_unicorn);
        db.insert("Fluffy the Pink Lion", R.drawable.fluffy_pink_lion);
        db.insert("Freeze the Penguin", R.drawable.freeze_penguin);
        db.insert("Fright the Cat", R.drawable.frights_cat);
        db.insert("Glamour the Leopard", R.drawable.glamour_leopard);
        db.insert("Halloween the Midnight Owl", R.drawable.halloween_midnight_owl);
        db.insert("Icecube the Penguin", R.drawable.icecube_penguin);
        db.insert("Icy Seal", R.drawable.icy_seal);
        db.insert("Jaden the Siamese Cat", R.drawable.jaden_siamese_cat);
        db.insert("Jinxy the Halloween Cat", R.drawable.jinxy_halloween_cat);
        db.insert("Katzie Mit", R.drawable.katzie_mit);
        db.insert("Kiki Cat", R.drawable.kiki_cat);
        db.insert("Leona Leopard", R.drawable.leona_leopard);
        db.insert("Maddie the Brown Dog", R.drawable.maddie_brown_dog);
        db.insert("Mist the Ghost", R.drawable.mist_ghost);
        db.insert("Muffin Cat", R.drawable.muffin_cat);
        db.insert("Neptune the Seahorse", R.drawable.neptune_seahorse);
        db.insert("Owlette the Owl", R.drawable.owlette_owl);
        db.insert("Pablo the Chihauhau", R.drawable.pablo_chihauhau);
        db.insert("Patsy Poodle", R.drawable.patsy_poodle);
        db.insert("Pegasus Poodle", R.drawable.pegasus_unicorn);
        db.insert("Piggly Pig", R.drawable.piggly_pig);
        db.insert("Rosie the Pink Turtle", R.drawable.rosie_pink_turtle);
        db.insert("Scarem Bat", R.drawable.scarem_bat);
        db.insert("Scooter Snail", R.drawable.scooter_snail);
        db.insert("Shadow the Halloween Kitty", R.drawable.shadow_halloween_kitty);
        db.insert("Slick Fox", R.drawable.slick_fox);
        db.insert("Slushy Husky", R.drawable.slushy_husky);
        db.insert("Squeaker Mouse", R.drawable.squeaker_mouse);
        db.insert("Tasha the Leopard", R.drawable.tasha_leopard);
        db.insert("Tracey Dog", R.drawable.tracy_dog);
        db.insert("Tundra the White Tiger", R.drawable.tundra_white_tiger);
        db.insert("Waddles the Penguin", R.drawable.waddles_penguin);
        db.insert("Whiskers Shnauzer", R.drawable.whiskers_shnauzer);
        db.insert("Wishful the Unicorn", R.drawable.wishful_unicorn);
        db.insert("ZigZag the Zebra", R.drawable.zigzag_zebra);
    }
}
