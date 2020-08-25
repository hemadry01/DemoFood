package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {

    private RecyclerView productShow;
    private ProductAdepter productAdepter;
    private List<Product> productList;
    
    private Toolbar toolbar;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        productShow=findViewById(R.id.product_show);
        databaseHelper=new DatabaseHelper(this);
        
        toolbar=findViewById(R.id.toolbar2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productShow.setHasFixedSize(true);
        productShow.setLayoutManager(linearLayoutManager);

        productList=new ArrayList<>();
        productAdepter= new ProductAdepter(productList,this);
        productShow.setAdapter(productAdepter);

        Cursor cursor=databaseHelper.showData();
        while (cursor.moveToNext()){

            int id=cursor.getInt(cursor.getColumnIndex(databaseHelper.FOOD_ID));
            String name=cursor.getString(cursor.getColumnIndex(databaseHelper.FOOD_NAME));
            String price = cursor.getString(cursor.getColumnIndex(databaseHelper.FOOD_PPRICE));

            productList.add(new Product(id,name,price));
            productAdepter.notifyDataSetChanged();
        }
        
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                productRating();
            }
        });
    }

    private void productRating() {

        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_message_box);
        RatingBar ratingBar=dialog.findViewById(R.id.ratingBar);
        TextView text=dialog.findViewById(R.id.textView);
        Button submit=dialog.findViewById(R.id.button_submit);
        text.setText("Product Rating");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReviewActivity.this, "Product Rating submit", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.show();
    }
}