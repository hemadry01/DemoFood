package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView add_itemCV,item_searchCV,order_itemCV,edit_orderCV,item_reviewCV,item_reportCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_itemCV=findViewById(R.id.add_item);
        item_searchCV=findViewById(R.id.search_item);
        order_itemCV=findViewById(R.id.order_item);
        edit_orderCV=findViewById(R.id.order_edit);
        item_reviewCV=findViewById(R.id.item_review);
        item_reportCV=findViewById(R.id.item_report);

        add_itemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Add Item", Toast.LENGTH_SHORT).show();
                Intent addItem=new Intent(MainActivity.this,AddItemActivity.class);
                startActivity(addItem);
            }
        });
        item_searchCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Item Search", Toast.LENGTH_SHORT).show();
                Intent searchItem=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(searchItem);
            }
        });
        order_itemCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent= new Intent(MainActivity.this,OrderActivity.class);
                startActivity(orderIntent);
            }
        });
        edit_orderCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Edit Order", Toast.LENGTH_SHORT).show();
            }
        });
        item_reviewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reviewIntent=new Intent(MainActivity.this,ReviewActivity.class);
                startActivity(reviewIntent);
            }
        });
        item_reportCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportIntent=new Intent(MainActivity.this,ReportActivity.class);
                startActivity(reportIntent);
            }
        });
    }
}