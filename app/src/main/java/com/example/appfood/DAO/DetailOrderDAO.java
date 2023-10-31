package com.example.appfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appfood.Database.DbHelper;
import com.example.appfood.Model.DetallOrder;

import java.util.ArrayList;

public class DetailOrderDAO {
    private DbHelper dbHelper;

    public DetailOrderDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<DetallOrder> getListCustomer(){
        ArrayList<DetallOrder> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
//int idDetallOrder, int idProduct, int idOrder, int quantity, int price,String addressBook, int totalPrice
        Cursor cursor = database.rawQuery("SELECT * FROM detallOrder ", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new DetallOrder(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getInt(6)));
            }while(cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<DetallOrder> getListDetail(int idOrder){
        ArrayList<DetallOrder> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
//int idDetallOrder, int idProduct, int idOrder, int quantity, int price,String addressBook, int totalPrice
        Cursor cursor = database.rawQuery("SELECT * FROM DETAILORDER where idOrder = ?", new String[]{String.valueOf(idOrder)});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                int idProduct = cursor.getInt(4);
                Cursor cursor1 = database.rawQuery("SELECT nameProduct FROM product where idProduct = ?", new String[]{String.valueOf(idProduct)});
                if(cursor1.getCount()>0){
                    cursor1.moveToFirst();
                    do{
                        list.add(new DetallOrder(cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getInt(2),
                                cursor.getString(3),
                                cursor.getInt(4),
                                cursor.getInt(5),
                                cursor1.getString(0)));
                    }while (cursor1.moveToNext());
                }
            }while(cursor.moveToNext());
        }
        return list;
    }

    public boolean addDetallOrder(DetallOrder detallOrder){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("quantity", detallOrder.getQuantity());
        values.put("price", detallOrder.getPrice());
        values.put("addressBook",detallOrder.getAddressBook());
        values.put("idProduct", detallOrder.getIdProduct());
        values.put("idOrder", detallOrder.getIdOrder());

        long check = database.insert("DETAILORDER", null, values);
        if(check==1)
            return true;
        return false;
    }

    public boolean updateDetallOrder(DetallOrder detallOrder){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("idProduct", detallOrder.getIdProduct());
        values.put("idOrder", detallOrder.getIdOrder());
        values.put("quantity", detallOrder.getQuantity());
        values.put("price", detallOrder.getPrice());
        values.put("addressBook",detallOrder.getAddressBook());

        long check = database.update("detallOrder", values, "idDetallOrder = ?", new String[]{String.valueOf(detallOrder.getIdDetallOrder())});
        if(check==1)
            return true;
        return false;
    }


}

