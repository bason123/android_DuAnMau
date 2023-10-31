package com.example.appfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appfood.Database.DbHelper;
import com.example.appfood.Model.Restaurant;

import java.util.ArrayList;

public class RestaurantDAO {
    private DbHelper dbHelper;

    public RestaurantDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Restaurant> getListRestaurant() {
        ArrayList<Restaurant> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
//int idRestaurant, String nameRestaurant, String addressRestaurant, String phoneRestaurant
        Cursor cursor = database.rawQuery("SELECT * FROM Restaurant ", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Restaurant(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public boolean addRestaurant(Restaurant restaurant) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nameRestaurant", restaurant.getNameRestaurant());
        values.put("addressRestaurant", restaurant.getAddressRestaurant());
        values.put("phoneRestaurant", restaurant.getPhoneRestaurant());
        long check = database.insert("restaurant", null, values);
        if (check == 1)
            return true;
        return false;
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nameRestaurant", restaurant.getNameRestaurant());
        values.put("addressRestaurant", restaurant.getAddressRestaurant());
        values.put("phoneRestaurant", restaurant.getPhoneRestaurant());
        long check = database.update("restaurant", values, "idRestaurant = ?", new String[]{String.valueOf(restaurant.getIdRestaurant())});
        if (check == 1)
            return true;
        return false;
    }
}
