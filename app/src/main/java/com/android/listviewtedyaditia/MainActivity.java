package com.android.listviewtedyaditia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView lv;

    int[] iconList = new int[]{
            R.drawable.kalkulator, R.drawable.kamera,
            R.drawable.stopwatch, R.drawable.senter,
            R.drawable.profil
    };

    String[] Headline = {"Kalkulator", "Kamera", "Stopwatch",
            "Senter", "Profil"
    };

    String[] Subhead = {"Alat penjumlahan angka", "kamera", "stopwatch",
            "lampu", "profil saya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);
        ListAdapter ListAdapter = new com.android.listviewtedyaditia.ListAdapter(this, iconList, Headline, Subhead);
        lv.setAdapter(ListAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Posisi kalkulator
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), kalkulator.class);
                    startActivityForResult(intent, 0);
                }

                //Posisi kamera
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), kamera.class);
                    startActivityForResult(intent, 0);
                }

                //posisi stopwatch
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), stopwatch.class);
                    startActivityForResult(intent, 0);
                }

                //posisi senter
                if (position == 3) {
                    Intent intent = new Intent(view.getContext(), senter.class);
                    startActivityForResult(intent, 0);
                }

                //posisi profil
                if (position == 4) {
                    Intent intent = new Intent(view.getContext(), profil.class);
                    startActivityForResult(intent, 0);
                }

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + Headline[position],
                        Toast.LENGTH_SHORT).show();


            }
        });
    }
}