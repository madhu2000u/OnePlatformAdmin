package com.madhu.oneplatformadmin.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.madhu.oneplatformadmin.MainActivity;

import java.util.Calendar;

public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Context context;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get((Calendar.MONTH));
        int date=calendar.get(Calendar.DATE);
        Log.d("msg", String.format("%d/%d/%d", date, month, year));
        return new DatePickerDialog(getActivity(), this, year, month, date);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
