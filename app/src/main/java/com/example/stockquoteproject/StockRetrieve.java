package com.example.stockquoteproject;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;

import edu.cofc.stock.Stock;

public class StockRetrieve extends AsyncTask<String,Void, Stock> {

    Stock stock;
    TextView symbol;
    TextView name;
    TextView price;
    TextView time;
    TextView change;
    TextView range;

    public StockRetrieve(TextView symbol,TextView name,TextView price,TextView time,TextView change,TextView range){
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.time = time;
        this.change = change;
        this.range = range;

    }

    @Override
    protected Stock doInBackground(String... params){
        stock = new Stock(params[0]);

        try{
            stock.load();
        }
        catch(IOException e){
            return stock;
        }
        return stock;
    }

    @Override
    protected void onPostExecute(Stock stock){
        symbol.setText(stock.getSymbol());
        name.setText(stock.getName());
        price.setText(stock.getLastTradePrice());
        time.setText(stock.getLastTradeTime());
        change.setText(stock.getChange());
        range.setText(stock.getRange());
    }




}
