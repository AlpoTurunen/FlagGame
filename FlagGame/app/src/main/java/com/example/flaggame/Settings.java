package com.example.flaggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView textView;
    SeekBar seekBar;
    Switch aSwitch;
    Switch bSwitch;
    public static int questionCount = 10;
    public static int language = 2;
    public static int independentCountriesIncluded = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textView = findViewById(R.id.infoTxt);
        seekBar = findViewById(R.id.seekBar);
        aSwitch = findViewById(R.id.languageSwitch);
        bSwitch = findViewById(R.id.countriesSwitch);


        // Select question amount
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Amount of questions: "+progress+"/226");
                questionCount = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Select answer language
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    language = 2;
                } else language = 1;
            }
        });

        // Select only independent countries
        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    independentCountriesIncluded = 2;
                } else independentCountriesIncluded = 1;
            }
        });

    }
}
