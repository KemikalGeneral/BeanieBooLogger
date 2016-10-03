package com.endorphinapps.kemikal.beanieboologger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetail extends AppCompatActivity {

    private TextView tv_itemTitle;
    private ImageView iv_itemImage;

    private Button btn_addBeanie;
    private Button btn_deleteBeanie;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        //Find all views
        findViews();

        //Get Intent Extras
        Intent intent = getIntent();
        final String beanieName = intent.getStringExtra("EXTRAS_NAME");
        //Set Text and Image from Extras
        tv_itemTitle.setText(beanieName);
        iv_itemImage.setImageResource(intent.getIntExtra("EXTRAS_IMAGE", 0));

        //Add isOwned to database 0=true 1=false
        btn_addBeanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(getApplicationContext());
                dbHelper.update(beanieName, 1);
            }
        });
    }

    private void findViews() {
        tv_itemTitle = (TextView) findViewById(R.id.detail_name);
        iv_itemImage = (ImageView) findViewById(R.id.detail_image);
        btn_addBeanie = (Button) findViewById(R.id.add_beanie);
        btn_deleteBeanie = (Button) findViewById(R.id.delete_beanie);
    }
}
