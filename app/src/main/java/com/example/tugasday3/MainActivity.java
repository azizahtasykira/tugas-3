package com.example.tugasday3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout1, layout2;
    private Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.facial);
        layout2 = findViewById(R.id.sunscreen);
        btnShare = findViewById(R.id.btn);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FaceWashActivity.class));
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SunscreenActivity.class));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND); //tindakan yang akan dilakukan oleh Intent
                intentShare.putExtra(Intent.EXTRA_TEXT, "Labore Sunscreen Rp.150.000");//menambahkan ekstra data dan menyimpan ekstra data yang akan dibagikan
                intentShare.setType("text/plain"); //menetapkan tipe data dari ekstra data

                //Ini adalah struktur kontrol if yang memeriksa apakah nilai yang dikembalikan oleh resolveActivity() tidak sama dengan null, yang berarti ada aktivitas yang dapat menangani Intent.
                //jika ada aktivitas yang dapat menangani Intent, blok kode di dalam kurung kurawal akan dijalankan.
                if (intentShare.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentShare);
                }
            }
        });
    }
}




