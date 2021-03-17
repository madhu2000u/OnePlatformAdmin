package com.madhu.oneplatformadmin.Adapters;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madhu.oneplatformadmin.MainActivity;
import com.madhu.oneplatformadmin.Networking.HttpClient;
import com.madhu.oneplatformadmin.R;
import com.madhu.oneplatformadmin.Utils.Utils;
import com.madhu.oneplatformadmin.data.Classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    private static Integer[] number ={0,1,2};         //number is the number of classes or recordings markable. this is just temporary
    private ArrayList<String> classes;
    private HttpClient client;
    private Context context;
    private ArrayAdapter<Integer> spinnerAdapter;
    public ClassAdapter(ArrayList<String> classes, Context context){
        this.classes=classes;
        this.context=context;
        spinnerAdapter=new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, number );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        client=new HttpClient(this.context);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final int curr_date=Calendar.getInstance().get(Calendar.DATE);
        final int curr_month=Calendar.getInstance().get(Calendar.MONTH);
        final int curr_year=Calendar.getInstance().get(Calendar.YEAR);
        holder.date_text.setText("Today");
        holder.subject.setText(classes.get(position));
        //holder.spinner.setOnItemSelectedListener(ClassAdapter.this);
        holder.spinner.setAdapter(spinnerAdapter);
        holder.mark_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, Classes.mark.getColumn(position), Toast.LENGTH_SHORT).show();
                client.sendRequest(Classes.mark.getColumn(position), holder.date_text.getText().toString().equals("Today")? Utils.getParsedString(curr_date, curr_month+1, curr_year ):holder.date_text.getText().toString(), number[holder.spinner.getSelectedItemPosition()].toString());
            }
        });

        holder.mark_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, Classes.mark.getColumn(position), Toast.LENGTH_SHORT).show();
                //if(holder.date_text.getText())
                client.sendRequest(Classes.rec.getColumn(position), holder.date_text.getText().toString().equals("Today")? Utils.getParsedString(curr_date, curr_month+1, curr_year ):holder.date_text.getText().toString(), number[holder.spinner.getSelectedItemPosition()].toString());


            }
        });

        holder.datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        String formattedDate= Utils.getParsedString( i2,i1+1,i);
                       // Toast.makeText(context, "Date-"+curr_date+" Month-"+curr_month+" yr-"+curr_year, Toast.LENGTH_LONG).show();
                        if(curr_date==i2 && curr_month==i1 && curr_year==i){
                            holder.date_text.setText("Today");
                        }else{
                            holder.date_text.setText(formattedDate);
                        }
                        //Toast.makeText(context, formattedDate, Toast.LENGTH_SHORT).show();


                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get((Calendar.MONTH)), Calendar.getInstance().get(Calendar.DATE)).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return classes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        Button mark_class, mark_rec;
        ImageButton datePicker;
        Spinner spinner;
        TextView subject, date_text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mark_class=itemView.findViewById(R.id.mark_class_button);
            mark_rec=itemView.findViewById(R.id.mark_rec_button);
            datePicker=itemView.findViewById(R.id.date);
            spinner=itemView.findViewById(R.id.classes_spinner);
            subject=itemView.findViewById(R.id.subject);
            date_text=itemView.findViewById(R.id.date_text);



        }
    }
}
