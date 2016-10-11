package com.endorphinapps.kemikal.beanieboologger;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Item detail, used when a beanie is selected from the main activity
 * Displays the beanie name and image with options to add or delete
 */

public class ItemDetail extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView tv_beanieName;
    private TextView tv_beanieBirthday;
    private ImageView iv_beanieImage;
    private Button btn_addBeanie;
    private Button btn_deleteBeanie;

    private DBHelper dbHelper;
    private Integer beanieID;
    private String beanieName;
    private int beanieImage;
    private String beanieBirthday;
    private int isOwned;

    //Start new Intent on back press so that a new MainActivity is created
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent createPage = new Intent(ItemDetail.this, MainActivity.class);
        startActivity(createPage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        //Find all views
        findViews();

        //Hide buttons/inputs until they're needed
        btn_addBeanie.setVisibility(View.GONE);
        btn_deleteBeanie.setVisibility(View.GONE);

        dbHelper = new DBHelper(this);

        //Get Intent Extras
        Intent intent = getIntent();
        beanieID = intent.getIntExtra("EXTRAS_ID", 0);
        beanieName = intent.getStringExtra("EXTRAS_NAME");
        beanieImage = intent.getIntExtra("EXTRAS_IMAGE", 0);
        beanieBirthday = intent.getStringExtra("EXTRAS_BIRTHDAY");
        isOwned = intent.getIntExtra("EXTRAS_IS_OWNED", 0);

        //Set Text, Birthday and Image from Extras
        tv_beanieName.setText(beanieName);
        tv_beanieBirthday.setText(beanieBirthday);
        iv_beanieImage.setImageResource(beanieImage);

        //If Beanie is owned, show the delete button
        //If not show the add button
        // 1=true 0=false
        if (isOwned == 0) {
            btn_addBeanie.setVisibility(View.VISIBLE);
        } else if (isOwned == 1) {
            btn_deleteBeanie.setVisibility(View.VISIBLE);
        }

        //Choose a date for the beanieBirthday
        //(leads to) Update DB isOwned to 1=true (onDateSet)
        btn_addBeanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get a new DatePicker and return the result in onDateSet - below
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getFragmentManager(), "datePicker");
            }
        });

        //Update DB isOwned to 0=false
        //Update birthday to null
        btn_deleteBeanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.updateIsOwned(beanieID, 0);
                //Remove birthday from DB - set date to null
                updateDB_Birthday(null);
            }
        });

        printDB();

        startOnLoadAnimations();
    }

    private void findViews() {
        tv_beanieName = (TextView) findViewById(R.id.detail_name);
        tv_beanieBirthday = (TextView) findViewById(R.id.detail_birthday);
        iv_beanieImage = (ImageView) findViewById(R.id.detail_image);
        btn_addBeanie = (Button) findViewById(R.id.add_beanie);
        btn_deleteBeanie = (Button) findViewById(R.id.delete_beanie);
    }

    private void startOnLoadAnimations() {
        Animation fade_in_text = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        tv_beanieName.startAnimation(fade_in_text);

        Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        iv_beanieImage.startAnimation(fade_in);

        Animation roll_in = AnimationUtils.loadAnimation(this, R.anim.roll_in);
        btn_addBeanie.startAnimation(roll_in);
    }

    private void printDB() {
        Log.v("z!", "=====================================================");
        ArrayList list = dbHelper.selectAllWithArray();
        for (Object element: list) {
            Log.v("z!", element.toString());
        }
    }

    //Simple intent to jump back and recreate the MainActivity
    private void refreshMainActivity() {
        Intent refresh = new Intent(ItemDetail.this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

    //Add the chosen date to the DB (for the birthday)
    //Implemented from DatePickerFragment Class
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        //Create a new string from the date
        String date = String.valueOf(new StringBuilder()
                .append(dayOfMonth)
                .append("-")
                .append(month+1)
                .append("-")
                .append(year));

        updateDB_Birthday(date);
        dbHelper.updateIsOwned(beanieID, 1);
    }

    //Update the birthday in the DB
    //Jump to the MainActivity
    private void updateDB_Birthday(String date) {
        dbHelper.updateBirthday(beanieID, date);

        refreshMainActivity();
    }
}
