package com.example.flaggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aloitaBtn = findViewById(R.id.aloitaBtn);
        Button selaileBtn = findViewById(R.id.selaileBtn);
        Button ohjeetBtn = findViewById(R.id.ohjeetBtn);
        Button asetuksetBtn = findViewById(R.id.asetuksetBtn);

        aloitaBtn.setOnClickListener(this);
        selaileBtn.setOnClickListener(this);
        ohjeetBtn.setOnClickListener(this);
        asetuksetBtn.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aloitaBtn:
                Intent GameMood = new Intent(getApplicationContext(), GameMood.class);
                startActivity(GameMood);
                break;
            case R.id.selaileBtn:
                Intent BrowseFlags = new Intent(getApplicationContext(), Browse.class);
                startActivity(BrowseFlags);
                break;
            case R.id.ohjeetBtn:
                Intent Instructions = new Intent(getApplicationContext(), Instructions.class);
                startActivity(Instructions);
                break;
            case R.id.asetuksetBtn:
                Intent Settings = new Intent(getApplicationContext(), Settings.class);
                startActivity(Settings);
                break;


        }
    }
}
