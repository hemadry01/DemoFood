package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    private EditText product_nameET,product_priceET;
    private Button product_saveBT;

    public String product_name,product_price;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        product_nameET=findViewById(R.id.name_product);
        product_priceET=findViewById(R.id.price_product);
        product_saveBT=findViewById(R.id.product_save);

        databaseHelper=new DatabaseHelper(this);

        product_saveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveProduct();
            }
        });
    }

    private void saveProduct() {

        product_name=product_nameET.getText().toString();
        product_price=product_priceET.getText().toString();

        if (!TextUtils.isEmpty(product_name)){
            if (!TextUtils.isEmpty(product_price)){

              long result= databaseHelper.insertData(product_name,product_price);
                Toast.makeText(this, "product is save successful", Toast.LENGTH_SHORT).show();


            }else {
                Toast.makeText(this, "Please Enter Product price!", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Please Enter Product name!", Toast.LENGTH_SHORT).show();
        }

    }
}