package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdepter extends RecyclerView.Adapter<ProductAdepter.productViewHolder>  {

    private List<Product>products;
   // private List<Product>productslist;
    private Context context;

    public ProductAdepter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
//        this.productslist=new ArrayList<>(products);
    }



    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.product_layout,parent,false);
        return new productViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {

        Product product=products.get(position);

        holder.name.setText(product.getProductname());
        holder.price.setText(product.getProductprice());
        holder.product_id.setText(String.valueOf(product.getId()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class productViewHolder extends RecyclerView.ViewHolder {
        private TextView name,price,product_id;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.product_name);
            price=itemView.findViewById(R.id.product_price);
            product_id=itemView.findViewById(R.id.product_id);

        }
    }
    public  void setFilter(ArrayList<Product>productArrayList){

        products = new ArrayList<>();
        products.addAll(productArrayList);
        notifyDataSetChanged();
    }
}
