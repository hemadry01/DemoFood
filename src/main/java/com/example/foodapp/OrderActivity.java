package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private Spinner sp;
    private TextView priceTV;
    private Button submitBT;
    DatabaseHelper databaseHelper;
    public List<Product> productList;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        sp=findViewById(R.id.spinner_item);
        priceTV=findViewById(R.id.textView_price);
        submitBT=findViewById(R.id.button_submit);

        databaseHelper=new DatabaseHelper(this);

        productList=new ArrayList<>();
        List<String> data = databaseHelper.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, data);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Cursor cursor=databaseHelper.showData();
                while (cursor.moveToNext()){

                    int id=cursor.getInt(cursor.getColumnIndex(databaseHelper.FOOD_ID));
                    String name=cursor.getString(cursor.getColumnIndex(databaseHelper.FOOD_NAME));
                    price = cursor.getString(cursor.getColumnIndex(databaseHelper.FOOD_PPRICE));

                   // productList.add(new Product(id,name,price));
                    Toast.makeText(OrderActivity.this, price, Toast.LENGTH_SHORT).show();
                    priceTV.setText(price);
                }
               // priceTV.getText(price);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}