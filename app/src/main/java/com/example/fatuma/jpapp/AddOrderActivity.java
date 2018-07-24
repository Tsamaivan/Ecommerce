package com.example.fatuma.jpapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddOrderActivity extends AppCompatActivity {

    EditText etitem;
    EditText etquantity;
    EditText etamount;
    TextView itstatus;
    TextView itdate;
    EditText etcomment;



     String item;
     String quantity;
     String amount;
     String status;
     String date;
     String comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        etitem = findViewById(R.id.etitem);
        etquantity = findViewById(R.id.etquantity);
        etamount = findViewById(R.id.etamount);
        itstatus = findViewById(R.id.itstatus);
        itdate = findViewById(R.id.itdate);
        etcomment = findViewById(R.id.etcomment);


    }

    public void selectstatus(View radioButton){
        int idChosen = radioButton.getId();
        if (idChosen == R.id.rPaid) {
            status = "Paid";
            Toast.makeText(this, "paid selected" + status, Toast.LENGTH_SHORT).show();
        } else if (idChosen == R.id.rCredit) {
            status = "Credit";
            Toast.makeText(this, "credit selected" + status, Toast.LENGTH_SHORT).show();
        }
    }
    public void saveUser(View saveButton) {

        item = etitem.getText().toString();
        quantity = etquantity.getText().toString();
        amount = etamount.getText().toString();
        date = itdate.getText().toString();
        comment = etcomment.getText().toString();

        if (!item.isEmpty() && !quantity.isEmpty() && !amount.isEmpty() && !date.isEmpty()
                && !comment.isEmpty()) {
            Order newUser = new Order(item, quantity, amount, status, date, comment);
            getDb().orderDao().insertOrder(newUser);

            Toast.makeText(this, "We typed item: " + newUser.getItem() + " and amount: " +
                    newUser.getAmount(), Toast.LENGTH_SHORT).show();



            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        }

    }
    private JpDatabase getDb() {
        String dataName = "room_db";
        JpDatabase db = Room.databaseBuilder(getApplicationContext(), JpDatabase.class, dataName)
                .allowMainThreadQueries().build();
        return db;
    }


}
