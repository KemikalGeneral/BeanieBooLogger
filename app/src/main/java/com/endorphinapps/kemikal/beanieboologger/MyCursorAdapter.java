package com.endorphinapps.kemikal.beanieboologger;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KeMiKaL on 29/09/2016.
 */

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
//        TextView name = (TextView) view.findViewById(R.id.item_name);
//        name.setText(cursor.getColumnIndex("name"));

        ImageView image = (ImageView) view.findViewById(R.id.item_image);
        image.setImageResource(cursor.getColumnIndex("image"));
    }
}
