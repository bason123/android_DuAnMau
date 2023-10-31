package com.example.appfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appfood.Database.DbHelper;
import com.example.appfood.Model.Customer;

import java.util.ArrayList;

public class CustomerDAO {
    private DbHelper dbHelper;

    public CustomerDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Customer> getListCustomer(){
        ArrayList<Customer> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM CUSTOMER ", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new Customer(cursor.getString(0),
                                     cursor.getString(1),
                                     cursor.getString(2),
                                    cursor.getString(3),
                                    cursor.getInt(4),
                                    cursor.getString(5)));
            }while(cursor.moveToNext());
        }

        return list;
    }

    public boolean addCustomer(Customer customer){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("phoneCustomer", customer.getPhoneCustomer());
        values.put("passWord", customer.getPassWord());
        values.put("nameCustomer", customer.getNameCustomer());
        values.put("addressCustomer", customer.getAddressCustomer());
        values.put("age", customer.getAge());
        values.put("gender", customer.getGender());

        long check = database.insert("CUSTOMER", null, values);
        if(check==1)
            return true;
        return false;
    }

    public boolean updateCustomer(Customer customer){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("phoneCustomer", customer.getPhoneCustomer());
        values.put("passWord", customer.getPassWord());
        values.put("nameCustomer", customer.getNameCustomer());
        values.put("addressCustomer", customer.getAddressCustomer());
        values.put("age", customer.getAge());
        values.put("gender", customer.getGender());

        long check = database.update("CUSTOMER", values, "phoneCustomer = ?", new String[]{customer.getPhoneCustomer()});
        if(check==1)
            return true;
        return false;
    }

    public boolean checkTk(String phoneCustomer){
        ArrayList<Customer> ds = this.getListCustomer();

        for (Customer customer: ds){
            if(phoneCustomer.equalsIgnoreCase(customer.getPhoneCustomer())) return false;
        }
        return true;
    }

    public boolean checkDN(String phoneCustomer, String passWord){
        ArrayList<Customer> ds = this.getListCustomer();

        for (Customer customer: ds){
            if(phoneCustomer.equalsIgnoreCase(customer.getPhoneCustomer()) && passWord.equalsIgnoreCase(customer.getPassWord())) return false;
        }
        return true;
    }


}
