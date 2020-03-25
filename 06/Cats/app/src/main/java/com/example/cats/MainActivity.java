package com.example.cats;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        view = findViewById(R.id.view);

        //создаём экземпляр Cat
        Cat barsik = new Cat();
        barsik.name = "Барсик";
        barsik.age = 8;
        barsik.color = Color.YELLOW;
        Gson gson = new Gson();

        //Конвертируем в объект Cat в строку
        String jsonText = gson.toJson(barsik);
        //String jsonText = "{'name':'Мурзик','color':-16777216,'age':8}";

        GsonBuilder builder = new GsonBuilder();
        Gson gson2 = builder.create();

        //Конвертируем в объект строку обратно в Cat
        Cat barsik2 = gson2.fromJson(jsonText, Cat.class);

        //показываем строку на экране
        textView.setText("Кот: "+barsik2.name+", "+barsik2.age+" лет, цвет:");
        //перекрашиваем View
        view.setBackgroundColor(barsik2.color);
    }
}
