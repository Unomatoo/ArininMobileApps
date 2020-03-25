package com.example.rview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Добавляем RecycleView
        RecyclerView rv = findViewById(R.id.list);
        //Устанавливаем менеджер слоёв.
        rv.setLayoutManager(new LinearLayoutManager(this));
        //Устанавливаем адаптер для списка.
        rv.setAdapter(new RViewAdapter(this, DummyContent.ITEMS));

    }
}
