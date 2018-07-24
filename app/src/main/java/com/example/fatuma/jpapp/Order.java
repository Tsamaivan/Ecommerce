package com.example.fatuma.jpapp;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Order {

    private String item;
    private String quantity;
    private String amount;
    private String status;
    private String date;
    private String comment;
    @PrimaryKey(autoGenerate = true)
    private int itemId;

    public Order(String item, String quantity, String amount, String status, String date,
                 String comment, int itemId) {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.date = date;
        this.comment = comment;
        this.itemId = itemId;
    }
@Ignore
    public Order(String item, String quantity, String amount, String status, String date, String comment) {
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.date = date;
        this.comment = comment;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
