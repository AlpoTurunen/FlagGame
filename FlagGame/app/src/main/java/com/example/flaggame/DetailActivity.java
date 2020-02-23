package com.example.flaggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mTextView = findViewById(R.id.textView);
        TextView mTextView2 = findViewById(R.id.textView2);
        ImageView mImageView = findViewById(R.id.imageView2);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mTextView.setText("Name is: "+mBundle.getString("countryName"));
            mImageView.setImageResource(mBundle.getInt("countryFlag"));
            mTextView2.setText("Capital is: "+mBundle.getString("capitalName"));


        }
    }
}
