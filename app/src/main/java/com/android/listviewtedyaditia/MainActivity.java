package com.android.listviewtedyaditia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private SharedPreference sharedPreference;


    private AlertDialog.Builder alertDialogBuilder;

    ListView lv;

    int[] iconList = new int[]{
            R.drawable.kalkulator, R.drawable.kamera,
            R.drawable.stopwatch, R.drawable.senter,
            R.drawable.maps, R.drawable.sms, R.drawable.sqlite, R.drawable.interneti, R.drawable.profil
    };

    String[] Headline = {"Kalkulator", "Kamera", "Stopwatch",
            "Senter", "Maps", "SMS","SQLite","Network", "Profil"
    };

    String[] Subhead = {"Alat penjumlahan angka", "kamera", "stopwatch",
            "lampu", "Google Maps", "Pengiriman Pesan","Lokal Database","Akses Internet", "Profil Saya"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, login.class);
        startActivity(intent);

        SharedPreference sharedPreference = new SharedPreference();

        alertDialogBuilder = new AlertDialog.Builder(this);

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

                //posisi maps
                if (position == 4) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    startActivityForResult(intent, 0);
                }

                //posisi SMS
                if (position == 5) {
                    Intent intent = new Intent(view.getContext(), SMSActivity.class);
                    startActivityForResult(intent, 0);
                }

                //posisi SQLite
                if (position == 6) {
                    Intent intent = new Intent(view.getContext(), SQLite.class);
                    startActivityForResult(intent, 0);
                }

                //posisi Network
                if (position == 7) {
                    Intent intent = new Intent(view.getContext(), Network.class);
                    startActivityForResult(intent, 0);
                }

                //posisi profil
                if (position == 8) {
                    Intent intent = new Intent(view.getContext(), profil.class);
                    startActivityForResult(intent, 0);
                }

                Toast.makeText(getApplicationContext(),
                        "Kamu Telah Memilih : " + Headline[position],
                        Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Keluar Aplikasi")
                .setMessage("Anda Yakin Ingin Keluar?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

}