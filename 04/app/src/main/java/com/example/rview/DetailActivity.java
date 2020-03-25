package com.example.rview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    static String ARG_ITEM_ID = "ARG_ITEM_ID";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String itemID = intent.getStringExtra(ARG_ITEM_ID);
        textView.setText(String.valueOf(itemID));
    }
}
