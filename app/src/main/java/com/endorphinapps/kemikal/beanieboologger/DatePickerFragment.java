package com.endorphinapps.kemikal.beanieboologger;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by KeMiKaL on 09/10/2016.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int day;
    private int month;
    private int year;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(), R.style.dialogue_theme, (ItemDetail)getActivity(), year, month, day);
    }

    //Empty, implemented in ItemDetail
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
