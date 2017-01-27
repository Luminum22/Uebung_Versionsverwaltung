package com.example.mediamarkt.uebung_versionsverwaltung.Anna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mediamarkt.uebung_versionsverwaltung.Kathrin.MainActivity_Kathrin;
import com.example.mediamarkt.uebung_versionsverwaltung.R;

public class MainActivity_Anna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anna);
        Button buttonShow=(Button)findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowClick(view);
            }
        });
        }
    private void onButtonShowClick(View view){
        Intent intent = new Intent(this, MainActivity_Kathrin.class);
        startActivity(intent);
    }
}
