package com.example.appfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appfood.Database.DbHelper;
import com.example.appfood.Model.Order;

import java.util.ArrayList;

public class OrdersDAO {
    private DbHelper dbHelper;

    public OrdersDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Order> getListOrders(){
        ArrayList<Order> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
//String phoneCustomer, String dateOrder, String status, String addressCustomer, int idRestaurant
        Cursor cursor = database.rawQuery("SELECT * FROM Orders ", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new Order(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getInt(5)));
            }while(cursor.moveToNext());
        }

        return list;
    }

    public boolean addOrder(Order order){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("phoneCustomer", order.getPhoneCustomer());
        values.put("dateOrder", order.getDateOrder());
        values.put("status", order.getStatus());
        values.put("addressCustomer", order.getAddressCustomer());
        values.put("idRestaurant",order.getIdRestaurant());
        long check = database.insert("orders", null, values);
        if(check==1)
            return true;
        return false;
    }

    public boolean updateOrders(Order order){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("phoneCustomer", order.getPhoneCustomer());
        values.put("dateOrder", order.getDateOrder());
        values.put("status", order.getStatus());
        values.put("addressCustomer", order.getAddressCustomer());
        values.put("idRestaurant", order.getIdRestaurant());
        long check = database.update("orders", values,"idOrder = ?", new String[]{String.valueOf(order.getIdOrder())});
        if(check==1)
            return true;
        return false;
    }


}
