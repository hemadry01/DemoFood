package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportActivity extends AppCompatActivity {

    private EditText productname,commentET;
    private Button submitBT;

    public String name,comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        productname=findViewById(R.id.product_name);
        commentET=findViewById(R.id.product_report);

        submitBT=findViewById(R.id.report_submit);

        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=productname.getText().toString();
                comment=commentET.getText().toString();

                if (!TextUtils.isEmpty(name)){
                    if (!TextUtils.isEmpty(comment)){

                       Intent intent=new Intent(Intent.ACTION_SEND);
                       intent.setData(Uri.parse("mailto:"));
                       String to ="sumanb843@gmail.com";
                       intent.putExtra(Intent.EXTRA_EMAIL,to);
                       intent.putExtra(Intent.EXTRA_SUBJECT,name);
                       intent.putExtra(Intent.EXTRA_TEXT,comment);
                       intent.setType("message/rfc822");
                       startActivity(intent);

                    }else {

                    }
                }else {

                }
            }
        });
    }
}