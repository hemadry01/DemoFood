package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView productShow;
    private ProductAdepter productAdepter;
    public List<Product>productList;
    public List<Product>productList1;
    private SearchView searchView;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        productShow=findViewById(R.id.product_show);

        databaseHelper=new DatabaseHelper(this);

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        MenuItem searchItem=menu.findItem(R.id.menu_id);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Product>products=new ArrayList<>();
        for (Product product:productList){
           String productName=product.getProductname().toLowerCase();
           if (productName.contains(newText)){
               products.add(product);
           }
        }
        productAdepter.setFilter(products);
        return false;
    }
}