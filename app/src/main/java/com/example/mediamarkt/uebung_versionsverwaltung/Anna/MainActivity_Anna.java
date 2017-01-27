package com.example.mediamarkt.uebung_versionsverwaltung.Anna;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mediamarkt.uebung_versionsverwaltung.Kathrin.MainActivity_Kathrin;
import com.example.mediamarkt.uebung_versionsverwaltung.R;

import java.util.Date;

public class MainActivity_Anna extends AppCompatActivity implements LocationListener{
private static LocationManager locationManager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anna);
        locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
        Button buttonShow=(Button)findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowClick(view);
            }
        });

        }

    @Override
    protected void onResume() {
        super.onResume();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            return;
            }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,5,this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            return;
        }
        locationManager.removeUpdates(this);
    }

    private void onButtonShowClick(View view){
        Intent intent = new Intent(this, MainActivity_Kathrin.class);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location==null)return;
        showLocation(location);
    }

    public void showLocation(Location location){
        TextView textViewLongitude=(TextView)findViewById(R.id.textViewLongitude);
        TextView textViewLatitude=(TextView)findViewById(R.id.textViewLatitude);
        TextView textViewDate=(TextView)findViewById(R.id.textViewDate);

        double longitude=location.getLongitude();
        double latitude=location.getLatitude();
        Date date=new Date();

        textViewLongitude.setText("Longitude:"+longitude);
        textViewLatitude.setText("Latitude:"+latitude);
        textViewDate.setText(date.toString());

        saveIntoDataBase(longitude,latitude,date);
    }

    private void saveIntoDataBase(double longitude, double latitude, Date date) {
        DbHelper dbHelper= new DbHelper(this);
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        db.execSQL(TblGpsData.STMT_INSERT, new String []{""+longitude, ""+latitude});
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }
    @Override
    public void onProviderEnabled(String s) {

    }
    @Override
    public void onProviderDisabled(String s) {

    }
}
