package com.android.listviewtedyaditia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_list_view extends AppCompatActivity {

    ActionBar actionBar;

    SQLiteDatabase SQLITEDATABASE;
    SQLiteHelper SQLITEHELPER;
    SQLiteListAdapter ListAdapter;

    Cursor cursor;

    ArrayList<String> ID_ArrayList = new ArrayList<>();
    ArrayList<String> PESAN_ArrayList = new ArrayList<>();

    ListView listView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.list);

        SQLITEHELPER = new SQLiteHelper(this);

    }

    @Override
    protected void onResume() {

        TampilSQLiteDBData();
        super.onResume();
    }

    @SuppressLint("Range")
    private void TampilSQLiteDBData() {
        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM Nama_Tabel", null);

        ID_ArrayList.clear();
        PESAN_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));
                PESAN_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_PESAN)));
            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(Activity_list_view.this, ID_ArrayList, PESAN_ArrayList);

        listView.setAdapter(ListAdapter);
        cursor.close();
    }
}