package com.example.appfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appfood.Database.DbHelper;
import com.example.appfood.Model.Product;

import java.util.ArrayList;

public class ProductDAO {
    private DbHelper dbHelper;

    public ProductDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
//int idProduct, int idRestaurant, String nameProduct, String description, int priceProduct
        Cursor cursor = database.rawQuery("SELECT * FROM Product ", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Product(cursor.getInt(0), cursor.getInt(1), cursor.getString(2),
                        cursor.getString(3), cursor.getInt(4)));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public boolean addProduct(Product product) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nameProduct", product.getNameProduct());
        values.put("description", product.getDescription());
        values.put("priceProduct", product.getPriceProduct());
        values.put("idRestaurant", product.getIdRestaurant());
        long check = database.insert("product", null, values);
        if (check == 1)
            return true;
        return false;
    }

    public boolean updateProduct(Product product) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nameProduct", product.getNameProduct());
        values.put("description", product.getDescription());
        values.put("priceProduct", product.getPriceProduct());
        values.put("idRestaurant", product.getIdRestaurant());
        long check = database.update("product", values, "idProduct = ?", new String[]{String.valueOf(product.getIdProduct())});
        if (check == 1)
            return true;
        return false;
    }
}
