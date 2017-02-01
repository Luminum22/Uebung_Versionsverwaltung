package com.example.mediamarkt.uebung_versionsverwaltung.Kathrin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mediamarkt.uebung_versionsverwaltung.Anna.DbHelper;
import com.example.mediamarkt.uebung_versionsverwaltung.R;

import java.util.ArrayList;

public class MainActivity_Kathrin extends AppCompatActivity {
ArrayList <GpsData> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__kathrin);
        loadData();
        setArrayList();
    }
    public void loadData ()
    {
        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        Cursor rows=db.rawQuery("SELECT longitude, latitude, date FROM gpsdata",null);
        while(rows.moveToNext())
        {
            GpsData gpsData = null;
            gpsData.longitude =rows.getDouble(0);
            gpsData.latitude =rows.getDouble(1);
            gpsData.date =rows.getString(2);
            arrayList.add(gpsData);
        }
    }

    public void setArrayList()
    {
        ArrayAdapter <GpsData> arrayAdapter=new ArrayAdapter<GpsData>(this,android.R.layout.simple_list_item_1,arrayList);
        ListView lw=(ListView)findViewById(R.id.listView);
        lw.setAdapter(arrayAdapter);
    }

}
