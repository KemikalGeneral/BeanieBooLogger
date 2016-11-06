package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

/**
 * Creates and adds all of the Beanies to the database,
 * reading and displaying them in a GridView,
 */

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private MyArrayAdapter myArrayAdapter;
    private boolean isDBInitialised;
    private String sharedPrefsName = "BEANIE_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all views
        findViews();

        //Set isDBInitialised to value of shared prefs
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefsName, MODE_PRIVATE);
        isDBInitialised = sharedPreferences.getBoolean("isDBInitialised", false);
        Log.v("z!", "DB " + isDBInitialised);

        //Setup Database from DBHelper Class
        //Uses shared prefs to check boolean value
        DBHelper db = new DBHelper(this);
        if (!isDBInitialised) {
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(db.getDatabaseName(), MODE_PRIVATE, null, null);

//        db.deleteTable(sqLiteDatabase);/** for testing **/

            //Create Database
            db.onCreate(sqLiteDatabase);
            //Add all Beanies
            addAllBeanies(db);
        }

        //Select all Beanies
        ArrayList list = db.selectAllWithArray();
        //Setup and add adapter
        myArrayAdapter = new MyArrayAdapter(this);
        myArrayAdapter.addAll(db.selectAllWithArray());
        gridView.setAdapter(myArrayAdapter);
        //Print DB
        printDB(list);
    }

    private void printDB(ArrayList list) {
        for (Object element : list) {
            Log.v("z!", element.toString());
        }
    }

    /** Find all Views **/
    private void findViews() {
        gridView = (GridView) findViewById(R.id.grid_view);
    }

    /** Add all beanies to the database
     * set shared prefs to true so not to reinitionalise DB **/
    private void addAllBeanies(DBHelper db) {
        db.insert("Alpine Red Horns", R.drawable.alpine_red_horns);//Not showing in the GridView?
        db.insert("Aria the Multicoloured Owl", R.drawable.aria_multicoloured_owl);
        db.insert("Asia the White Tiger", R.drawable.asia_white_tiger);
        db.insert("Austin the Orange Eared Dog", R.drawable.austin_orange_ear_dog);
        db.insert("Avril the Rabbit", R.drawable.avril_rabbit);
        db.insert("Barley the Dog", R.drawable.barley_dog);
        db.insert("Bloom the Multicoloured Bunny", R.drawable.bloom_multicoloured_bunny);
        db.insert("Blossom the Multicoloured Lamb", R.drawable.blossom_multicoloured_lamb);
        db.insert("Bongo the Gorilla", R.drawable.bongo_gorilla);
        db.insert("Boom Boom the Panda", R.drawable.boom_boom_panda);
        db.insert("Brutus the Boxer Dog", R.drawable.brutus_boxer_dog);
        db.insert("Buckwheat the Lynx", R.drawable.buckwheat_lynx);
        db.insert("Bugsy the Lady Bug", R.drawable.bugsy_ladybug);
        db.insert("Casanova the Monkey", R.drawable.casanova_monkey);
        db.insert("Cashmere the Cat", R.drawable.cashmere_cat);
        db.insert("Charming the Pink Gorilla", R.drawable.charming_pink_gorilla);
        db.insert("Cinder the Dragon", R.drawable.cinder_dragon);
        db.insert("Clover the Lamb", R.drawable.clover_lamb);
        db.insert("Coconut the Monkey", R.drawable.coconut_monkey);
        db.insert("Comet the Reindeer", R.drawable.comet_reindeer);
        db.insert("Cookie the Dog", R.drawable.cookie_dog);
        db.insert("Cookie the Heart Dog", R.drawable.cookie_dog_with_heart);
        db.insert("Corkey the Pig", R.drawable.corkey_pig);
        db.insert("Cuddly the Bear", R.drawable.cuddly_bear);
        db.insert("Cutie Pie the Panda", R.drawable.cutie_pie_panda);
        db.insert("Daisy the Cow", R.drawable.daisy_cow);
        db.insert("Dakota the Horse", R.drawable.dakota_horse);
        db.insert("Darla the Pink Dragon", R.drawable.darla_pink_dragon);
        db.insert("Dill the Green Dog", R.drawable.dill_green_dog);
        db.insert("Diva the White Dog", R.drawable.diva_white_dog);
        db.insert("Dotty the Leopard", R.drawable.dotty_leopard);
        db.insert("Dougie the Dog", R.drawable.dougie_dog);
        db.insert("Duke the Dog", R.drawable.duke_dog);
        db.insert("Ellie the Elephant", R.drawable.ellie_elephant);
        db.insert("Fairbanks the Penguin", R.drawable.fairbanks_penguin);
        db.insert("Fantasia the Unicorn", R.drawable.fantasia_unicorn);
        db.insert("Flips the Dolphin", R.drawable.flips_dolphin);
        db.insert("Flora the Skunk", R.drawable.flora_skunk);
        db.insert("Fluffy the Pink Lion", R.drawable.fluffy_pink_lion);
        db.insert("Freeze the Penguin", R.drawable.freeze_penguin);
        db.insert("Frights the Cat", R.drawable.frights_cat);
        db.insert("Georgia the Dalmation", R.drawable.georgia_dalmation);
        db.insert("Gholie the Orange Ghost", R.drawable.gholie_orange_ghost);
        db.insert("Ghosty the Ghost", R.drawable.ghosty_ghost);
        db.insert("Glamour the Leopard", R.drawable.glamour_leopard);
        db.insert("Glider the Pink Penguin", R.drawable.glider_pink_penguin);
        db.insert("Gobbler the Turkey", R.drawable.gobbler_turkey);
        db.insert("Gobbles the Turkey", R.drawable.gobbles_turkey);
        db.insert("Goldie the Chick", R.drawable.goldie_chick);
        db.insert("Grapes the Purple Monkey", R.drawable.grapes_purple_monkey);
        db.insert("Grimm the Ghost", R.drawable.grimm_ghost);
        db.insert("Hero the Lion", R.drawable.hero_lion);
        db.insert("Honey the Bear", R.drawable.honey_bear);
        db.insert("Honey Bun the Dog", R.drawable.honey_bun_dog);
        db.insert("Hope for Japan", R.drawable.hope_for_japan);
        db.insert("Hopson the Brown Bunny", R.drawable.hopson_brown_bunny);
        db.insert("Iceberg the Seal", R.drawable.iceberg_seal);
        db.insert("Icecube the Penguin", R.drawable.icecube_penguin);
        db.insert("Icy Seal", R.drawable.icy_seal);
        db.insert("Igloo the Penguin", R.drawable.igloo_penguin);
        db.insert("Igor the Bat", R.drawable.igor_bat);
        db.insert("Jaden the Siamese Cat", R.drawable.jaden_siamese_cat);
        db.insert("Jinxy the Halloween Cat", R.drawable.jinxy_halloween_cat);
        db.insert("Julep the Monkey", R.drawable.julep_monkey);
        db.insert("Junglelove the Pink Giraffe", R.drawable.junglelove_pink_giraffe);
        db.insert("Kacey the Pink Koala", R.drawable.kacey_pink_koala);
        db.insert("Kiki Cat", R.drawable.kiki_cat);
        db.insert("Lala the White Lamb", R.drawable.lala_white_lamb);
        db.insert("Lavender the Purple Lamb", R.drawable.lavender_purple_lamb);
        db.insert("Legs the Octopus", R.drawable.legs_octopus);
        db.insert("Leona Leopard", R.drawable.leona_leopard);
        db.insert("Lindi the Cat", R.drawable.lindi_cat);
        db.insert("London the Purple Eared Dog", R.drawable.london_purple_eared_dog);
        db.insert("Lucy the Owl", R.drawable.lucy_owl);
        db.insert("Mac the Mouse", R.drawable.mac_mouse);
        db.insert("Maddie the Brown Dog", R.drawable.maddie_brown_dog);
        db.insert("Magic the Pink Unicorn", R.drawable.magic_pink_unicorn);
        db.insert("Midnight the Bat", R.drawable.midnight_bat);
        db.insert("Midnight the Orange Owl", R.drawable.midnight_orange_owl);
        db.insert("Mist the Ghost", R.drawable.mist_ghost);
        db.insert("Muffin Cat", R.drawable.muffin_cat);
        db.insert("Myrtle the Pink Turtle", R.drawable.myrtle_pink_turtle);
        db.insert("Neptune the Seahorse", R.drawable.neptune_seahorse);
        db.insert("Oscar the Owl", R.drawable.oscar_owl);
        db.insert("Owlette the White Owl", R.drawable.owlette_white_owl);
        db.insert("Owliver the Camouflage Owl", R.drawable.owliver_camouflage_owl);
        db.insert("Pablo the Chihauhau", R.drawable.pablo_chihuahua);
        db.insert("Paddles the Pink Penguin", R.drawable.paddles_pink_penguin);
        db.insert("Pashun the Pink Chihuahua", R.drawable.pashun_pink_chihuahua);
        db.insert("Patches the Leopard", R.drawable.patches_leopard);
        db.insert("Patsy Poodle", R.drawable.patsy_poodle);
        db.insert("Pegasus the Unicorn", R.drawable.pegasus_unicorn);
        db.insert("pellie the Cat", R.drawable.pellie_cat);
        db.insert("Pepper the Cat", R.drawable.pepper_cat);
        db.insert("Phantom the Ghost", R.drawable.phantom_ghost);
        db.insert("Pierre the Pink Seal", R.drawable.pierre_pink_seal);
        db.insert("Piggley the Pig", R.drawable.piggley_pig);
        db.insert("Pinky the Pink Barn Owl", R.drawable.pinky_pink_barn_owl);
        db.insert("Pippie the White Dog", R.drawable.pippie_white_dog);
        db.insert("Precious the Dog", R.drawable.precious_dog);
        db.insert("Presents the Dog", R.drawable.presents_dog);
        db.insert("Pugsley the Pug", R.drawable.pugsley_pup);
        db.insert("Rainbow the Unicorn", R.drawable.rainbow_unicorn);
        db.insert("Razberry the Monkey", R.drawable.razberry_monkey);
        db.insert("Reagan the Pink Spotted Cat", R.drawable.reagan_pink_spotted_cat);
        db.insert("Rebel the Meerkat", R.drawable.rebel_meerkat);
        db.insert("Rocco the Raccoon", R.drawable.rocco_raccoon);
        db.insert("Romeo the Gorilla", R.drawable.romeo_gorilla);
        db.insert("Rootbeer the Terrier", R.drawable.rootbeer_terrier);
        db.insert("Rootbeer the Terrier", R.drawable.rootbeer_terrier);
        db.insert("Rosie the Pink Turtle", R.drawable.rosie_pink_turtle);
        db.insert("Roxie the Raccoon", R.drawable.roxie_raccoon);
        db.insert("Ruby the Red Monkey", R.drawable.ruby_red_monkey);
        db.insert("Safari the Giraffe", R.drawable.safari_giraffe);
        db.insert("Sammy the Brown Owl", R.drawable.sammy_brown_owl);
        db.insert("Sammy the Fish", R.drawable.sammy_fish);
        db.insert("Sandy the Turtle", R.drawable.sandy_turtle);
        db.insert("Scarem Bat", R.drawable.scarem_bat);
        db.insert("Scoop the Snowman", R.drawable.scoop_snowman);
        db.insert("Scooter Snail", R.drawable.scooter_snail);
        db.insert("Scraps the Dog", R.drawable.scraps_dog);
        db.insert("Serena the Pink Leopard", R.drawable.serena_pink_leopard);
        db.insert("Shadow the Halloween Kitty", R.drawable.shadow_halloween_kitty);
        db.insert("Shelby the Pink Turtle", R.drawable.shelby_pink_turtle);
        db.insert("Sky High Giraffe", R.drawable.sky_high_giraffe);
        db.insert("Slick Fox", R.drawable.slick_fox);
        db.insert("Slowpoke the Purple Turtle", R.drawable.slowpoke_purple_turtle);
        db.insert("Slushy Husky", R.drawable.slushy_husky);
        db.insert("Sophie the Pink Cat", R.drawable.sophie_pink_cat);
        db.insert("Sparkles the Pink Dolphin", R.drawable.sparkles_pink_dolphin);
        db.insert("Speckles the Frog", R.drawable.speckles_frog);
        db.insert("Speckles the Leopard", R.drawable.speckles_leopard);
        db.insert("Specks the Elephant", R.drawable.specks_elephant);
        db.insert("Spells the Snow Owl", R.drawable.spells_snow_owl);
        db.insert("Spike the Hedgehog", R.drawable.spike_hedgehog);
        db.insert("Squeaker Mouse", R.drawable.squeaker_mouse);
        db.insert("Sting the Bee", R.drawable.sting_bee);
        db.insert("Stripes the Tiger", R.drawable.stripes_tiger);
        db.insert("Sugar Pie the Pink Unicorn", R.drawable.sugar_pie_pink_unicorn);
        db.insert("Sugar the Pink Elephant", R.drawable.sugar_pink_elephant);
        db.insert("Sweetly the Sitting Polar Bear", R.drawable.sweetly_sitting_polar_bear);
        db.insert("Swoops the Barn Owl", R.drawable.swoops_barn_owl);
        db.insert("Sydney the Teal Leopard", R.drawable.sydney_teal_leopard);
        db.insert("Tabitha the Tabby Cat", R.drawable.tabitha_tabby_cat);
        db.insert("Tangerine the Orangutan", R.drawable.tangerine_orangutan);
        db.insert("Tasha the Leopard", R.drawable.tasha_leopard);
        db.insert("Tauri the Tan Cat", R.drawable.tauri_tan_cat);
        db.insert("Tender the Elephant", R.drawable.tender_elephant);
        db.insert("Thankful the Turkey", R.drawable.thankful_turkey);
        db.insert("Tomato the Red Dog", R.drawable.tomato_red_dog);
        db.insert("Tracey Dog", R.drawable.tracy_dog);
        db.insert("Treats the Pumpkin Ghost", R.drawable.treats_pumpkin_ghost);
        db.insert("Tuffty the Rottweiler", R.drawable.tuffy_rottweiler);
        db.insert("Tundra the Polar Bear", R.drawable.tundra_polar);
        db.insert("Tundra the White Tiger", R.drawable.tundra_white_tiger);
        db.insert("Tusks the Pink Walrus", R.drawable.tusk_pink_walrus);
        db.insert("Twigs the Giraffe", R.drawable.twigs_giraffe);
        db.insert("Twinkles Toes the Ballerina Bunny", R.drawable.twinkle_toes_ballerina_bunny);
        db.insert("Waddles the Penguin", R.drawable.waddles_penguin);
        db.insert("Whiskers Shnauzer", R.drawable.whiskers_shnauzer);
        db.insert("Willow the Grey Cat", R.drawable.willow_grey_cat);
        db.insert("Wise Owl", R.drawable.wise_owl);
        db.insert("Wishful the Unicorn", R.drawable.wishful_unicorn);
        db.insert("ZigZag the Zebra", R.drawable.zigzag_zebra);
        db.insert("Zippy the Green Turtle", R.drawable.zippy_green_turtle);
        db.insert("Zoe the Zebra", R.drawable.zoe_zebra);

        //Set to true to stop initialising onCreate
        SharedPreferences.Editor editor = getSharedPreferences(sharedPrefsName, MODE_PRIVATE).edit();
        editor.putBoolean("isDBInitialised", true);
        editor.apply();
    }
}
