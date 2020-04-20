package com.example.stockquoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText symbolEntry;

    TextView symbol;
    TextView name;
    TextView price;
    TextView time;
    TextView change;
    TextView range;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        symbolEntry = findViewById(R.id.symbolEntry);

        symbol = findViewById(R.id.fetchSymbol);
        name = findViewById(R.id.fetchName);
        price = findViewById(R.id.fetchLastTradePrice);
        time = findViewById(R.id.fetchLastTradeTime);
        change = findViewById(R.id.fetchChange);
        range = findViewById(R.id.fetchRange);


    }
}
