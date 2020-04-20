package com.example.stockquoteproject;


import android.content.Context;
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

    Boolean error;
    Context toastContext;

    public StockRetrieve(TextView symbol,TextView name,TextView price,TextView time,TextView change,TextView range,Context context){
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.time = time;
        this.change = change;
        this.range = range;
        error = false;
        toastContext = context;

    }

    @Override
    protected Stock doInBackground(String... params){
        stock = new Stock(params[0]);

        try{
            stock.load();
        }
        catch(IOException e){
            Log.i("IOException",e.getMessage());
            error = true;

        }
        return stock;
    }

    @Override
    protected void onPostExecute(Stock stock){
        if(error){
            Toast toast = Toast.makeText(toastContext,"Error in retrieving stock symbol",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            symbol.setText(stock.getSymbol());
            name.setText(stock.getName());
            price.setText(stock.getLastTradePrice());
            time.setText(stock.getLastTradeTime());
            change.setText(stock.getChange());
            range.setText(stock.getRange());
        }
    }




}
