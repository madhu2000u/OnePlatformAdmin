package com.madhu.oneplatformadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.madhu.oneplatformadmin.Adapters.ClassAdapter;
import com.madhu.oneplatformadmin.data.Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClassAdapter adapter;

    private ArrayList<String> classes=new ArrayList<>(Arrays.asList(Classes.CRE2,Classes.ESO, Classes.PDC, Classes.HSIR, Classes.ECRE, Classes.CS, Classes.IOT,  Classes.OT, Classes.HT, Classes.CRE, Classes.PST, Classes.HONS));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ClassAdapter(classes, this);
        recyclerView.setAdapter(adapter);




    }
}