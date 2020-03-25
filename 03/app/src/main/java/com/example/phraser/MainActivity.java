package com.example.phraser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String string;
    Button swapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_result);
        swapBtn = findViewById(R.id.button2);

        string = Phraser.PhraserGen();
        textView.setText(string);
    }

    public void onGenClick(View view) {
        swapBtn.setEnabled(true);
        string = Phraser.PhraserGen();
        textView.setText(string);
    }

    public void onSwapClick(View view) {
        swapBtn.setEnabled(false);
        string = Phraser.SwapSubStrings(string);
        textView.setText(string);
    }
}
