package com.example.stockquoteproject;

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



        symbolEntry.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN)&& (keyCode==KeyEvent.KEYCODE_ENTER)){
                    StockRetrieve retrieve = new StockRetrieve(symbol,name,price,time,change,range);
                    retrieve.execute(symbolEntry.getText().toString());
                }
                return false;
            }
        });
    }

}
