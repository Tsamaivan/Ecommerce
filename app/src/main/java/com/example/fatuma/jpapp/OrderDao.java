package com.example.fatuma.jpapp;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface OrderDao {

    @Query("SELECT * FROM `Order`")
    List<Order> getAllOrderfromDb();
    @Query("SELECT * FROM `Order` WHERE itemId= :id")
   Order getOrderByid(int id);
    @Insert
    void insertOrder(Order order);

    @Delete
    void deleteOrder(Order user);
    @Update
    void updateOrder(Order user);
}
