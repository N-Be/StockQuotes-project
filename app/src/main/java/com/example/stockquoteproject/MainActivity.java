package com.example.stockquoteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.EventListener;

import edu.cofc.stock.Stock;

public class MainActivity extends AppCompatActivity {

    EditText symbolEntry;

    TextView symbol;
    TextView name;
    TextView price;
    TextView time;
    TextView change;
    TextView range;

    Stock stock;


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

        stock = new Stock(symbolEntry.getText().toString());

        symbolEntry.requestFocus();


        symbolEntry.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN)&& (keyCode==KeyEvent.KEYCODE_ENTER)){
                    StockRetrieve retrieve = new StockRetrieve(symbol,name,price,time,change,range,getApplicationContext());
                    retrieve.execute(symbolEntry.getText().toString());
                }
                return false;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("symbolEntry",symbolEntry.getText().toString());
        outState.putString("symbol",symbol.getText().toString());
        outState.putString("name",name.getText().toString());
        outState.putString("price",price.getText().toString());
        outState.putString("time",time.getText().toString());
        outState.putString("change",change.getText().toString());
        outState.putString("range",range.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        symbolEntry.setText(savedInstanceState.getString("symbolEntry"));
        symbol.setText(savedInstanceState.getString("symbol"));
        name.setText(savedInstanceState.getString("name"));
        price.setText(savedInstanceState.getString("price"));
        time.setText(savedInstanceState.getString("time"));
        change.setText(savedInstanceState.getString("change"));
        range.setText(savedInstanceState.getString("range"));

    }

}
