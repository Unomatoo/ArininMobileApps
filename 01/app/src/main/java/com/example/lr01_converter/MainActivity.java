package com.example.lr01_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    double diffCoeff = 0.264172;
    double liters = 0;
    double gallons = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView3);

        calc();
    }

    private void calc() {
        checkData();
        liters = Double.parseDouble(editText.getText().toString());
        gallons = liters*diffCoeff;
        textView.setText(String.valueOf(gallons));
    }

    public void onOKButtonClick(View view) {
        calc();
    }

    public void onHelpButtonClick(View view) {
        checkData();
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        intent.putExtra(HelpActivity.EXTRA_LITERS, liters);
        intent.putExtra(HelpActivity.EXTRA_GALLONS, gallons);
        startActivity(intent);
    }

    private void checkData() {
        String editStr = editText.getText().toString();
        if (editStr.equals("")) {
            editText.setText(String.valueOf(0));
        }
    }
}
