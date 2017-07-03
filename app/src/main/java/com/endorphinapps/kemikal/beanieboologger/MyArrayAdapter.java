package com.endorphinapps.kemikal.beanieboologger;

/**
 * Created by KeMiKaL on 20/09/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class MyArrayAdapter extends android.widget.ArrayAdapter<Item> {

    DBHelper db = new DBHelper(getContext());
    int isOwned = 0;

    /**
     * Constructor for Adapter
     * @param context
     */
    MyArrayAdapter(Context context) {
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
        final ImageView image = (ImageView) convertView.findViewById(R.id.item_image);
        image.setImageResource(item.getImage());

        //Set background colour if beanie isOwned
        isOwned = db.getIsOwned(item.get_id());
        if (isOwned == 0) {
            image.setBackgroundResource(R.drawable.beanie_item_background_not_owned);
        } else if (isOwned == 1) {
            image.setBackgroundResource(R.drawable.beanie_item_background_white);
        }

        //OnLoad Animations
        onLoadAnimations(image);

        //OnClick
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ItemDetail.class);
                intent.putExtra("EXTRAS_ID", item.get_id());
                intent.putExtra("EXTRAS_NAME", item.getName());
                intent.putExtra("EXTRAS_IMAGE", item.getImage());
                intent.putExtra("EXTRAS_BIRTHDAY", item.getBirthday());
                intent.putExtra("EXTRAS_IS_OWNED", item.getIsOwned());
                getContext().startActivity(intent);
                ((Activity)getContext()).finish();
            }
        });

        //On LONG click
//        convertView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                GridView gridView = new GridView(getContext());
//
//                List<String> colours = new ArrayList<String>();
//                colours.add("Red");
//                colours.add("Orange");
//                colours.add("Yellow");
//                colours.add("Green");
//                colours.add("Blue");
//                colours.add("Pink");
//                colours.add("Purple");
//
//                gridView.setAdapter(new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, colours));
//                gridView.setNumColumns(1);
//                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        switch (position) {
//                            case 0 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_red)); break;
//                            case 1 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_orange)); break;
//                            case 2 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_yellow)); break;
//                            case 3 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_green)); break;
//                            case 4 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_blue)); break;
//                            case 5 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_pink)); break;
//                            case 6 : image.setBackgroundColor(getContext().getResources().getColor(R.color.owned_purple)); break;
//                        }
//                    }
//                });
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setView(gridView);
//                builder.setTitle("Choose a Colour");
//                builder.show();
//
//                return true;
//            }
//        });

        return convertView;
    }

    /**
     * Start onLoad animations
     * 'Rattle' images indefinitely
     * @param image
     */
    private void onLoadAnimations(ImageView image) {
        Animation rattle = AnimationUtils.loadAnimation(getContext(), R.anim.rattle);
        image.startAnimation(rattle);
    }
}
