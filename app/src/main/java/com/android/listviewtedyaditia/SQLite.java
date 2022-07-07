package com.android.listviewtedyaditia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SQLite extends AppCompatActivity {

    ActionBar actionBar;

    TextInputEditText GetPesan;
    Button Simpan, Tampil;
    String Pesan;
    Boolean CekPesanKosong;

    String SQLiteQuery;
    SQLiteDatabase sqLiteDatabase;

    //navigasi tombol back
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //Aplikasi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GetPesan = findViewById(R.id.pesan);

        Simpan = findViewById(R.id.simpan);
        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuatDatabase();
                KirimDataKeDB();
            }
        });

        Tampil = findViewById(R.id.tampil);
        Tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SQLite.this, Activity_list_view.class);
                startActivity(intent);
            }
        });

    }

    private void BuatDatabase() {
        sqLiteDatabase = openOrCreateDatabase("Nama_Database_Baru", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Nama_Tabel (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pesan VARCHAR);");
    }

    private void KirimDataKeDB() {
        Pesan = Objects.requireNonNull(GetPesan.getText()).toString();

        CekPesanKosong(Pesan);

        if (CekPesanKosong) {
            //Jika edit teks tidak kosong, maka disimpan
            SQLiteQuery = "INSERT INTO Nama_Tabel (pesan) VALUES ('" + Pesan + "');";
            sqLiteDatabase.execSQL(SQLiteQuery);
            Toast.makeText(SQLite.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

            GetPesan.getText().clear();

        } else {
            //Jika kosong, maka tampilkan toast
            Toast.makeText(SQLite.this, "Masukan Datanya Dulu", Toast.LENGTH_SHORT).show();
        }
    }

    private void CekPesanKosong(String pesan) {
        CekPesanKosong = !TextUtils.isEmpty(pesan);
    }
}