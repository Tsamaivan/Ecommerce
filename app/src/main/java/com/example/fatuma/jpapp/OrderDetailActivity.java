package com.example.fatuma.jpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {

    TextView itamount;
    TextView itpen;
    TextView itquantity;
    TextView itstatus;
    TextView itdate;
    TextView itcomment;
    int itemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        itamount = findViewById(R.id.etamount);
        itpen= findViewById(R.id.lepen);
        itquantity = findViewById(R.id.lequantity);
        itstatus= findViewById(R.id.lestatus);
        itdate = findViewById(R.id.ledate);
        itcomment= findViewById(R.id.lecomment);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            itemId = intent.getIntExtra(Intent.EXTRA_TEXT,-1);

    }



        }
}
