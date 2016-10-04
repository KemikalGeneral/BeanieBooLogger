package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends android.widget.ArrayAdapter<Item> {

    public MyArrayAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //Get item position
        final Item item = getItem(position);

        //Set image
        ImageView image = (ImageView) convertView.findViewById(R.id.item_image);
        image.setImageResource(item.getImage());

        //Set text
//        TextView name = (TextView) convertView.findViewById(R.id.item_name);
//        name.setText(item.getName());

        //OnClick
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ItemDetail.class);
                intent.putExtra("EXTRAS_NAME", item.getName());
                intent.putExtra("EXTRAS_IMAGE", item.getImage());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
