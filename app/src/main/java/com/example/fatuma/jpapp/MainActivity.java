package com.example.fatuma.jpapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OrderListAdapter.OrderListItemAdapter {
    RecyclerView orderRecyclerView;
    OrderListAdapter orderListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neworder = new Intent(MainActivity.this, AddOrderActivity.class);
                startActivity(neworder);


            }
        });
        orderRecyclerView = findViewById(R.id.orderRecyclerView);
        orderListAdapter = new OrderListAdapter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(linearLayoutManager);
        orderRecyclerView.setHasFixedSize(true);
        orderRecyclerView.setAdapter(orderListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Order> orderList = getDb().orderDao().getAllOrderfromDb();
        orderListAdapter.setOrderData(orderList);

    }

    private JpDatabase getDb() {
        String dataName = "room_db";
        JpDatabase db = Room.databaseBuilder(getApplicationContext(), JpDatabase.class, dataName)
                .allowMainThreadQueries().build();
        return db;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int itemId) {
        Intent takeMeToDetailActivity = new Intent(this, OrderDetailActivity.class);
        takeMeToDetailActivity.putExtra(Intent.EXTRA_TEXT, itemId);
        startActivity(takeMeToDetailActivity);
    }
}
