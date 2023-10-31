package com.example.appfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "AppFood", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RESTAURANT(idRestaurant integer primary key autoincrement, nameRestaurant text, addressRestaurant text, phoneRestauran text)");
        db.execSQL("CREATE TABLE CUSTOMER(phoneCustomer text primary key, passWord text, nameCustomer text, addressCustomer text, age int, gender text) ");
        db.execSQL("CREATE TABLE PRODUCT(idProduct integer primary key autoincrement, nameProduct text, description text, price integer, idRestaurant integer REFERENCES RESTAURANT(idRestaurant))");
        db.execSQL("CREATE TABLE ORDERS(idOrder integer primary key autoincrement, dateOrder text, status text, addressCustomer text, phoneCustomer text REFERENCES CUSTOMER(phoneCustomer)," +
                "idRestaurant integer REFERENCES RESTAURANT(idRestaurant))");
        db.execSQL("CREATE TABLE DETAILORDER(idDetallOrder integer primary key autoincrement, quantity integer, price integer, addressBook text ,idProduct integer REFERENCES PRODUCT(idProduct), idOrder integer REFERENCES ORDERR(idOrder))");

        db.execSQL("INSERT INTO RESTAURANT VALUES(1, 'Tư Nhớ', '330 Nguyễn Thị Thập - Quận 7' ,'0987777888')");
        db.execSQL("INSERT INTO RESTAURANT VALUES(2, 'Việt Hương', '3 Phạm Văn Đồng - Quận GV' ,'0984747477')");
        db.execSQL("INSERT INTO RESTAURANT VALUES(3, 'Trường Thịnh', '34 Tô Ký - Quận 12' ,'0337295209')");
        db.execSQL("INSERT INTO RESTAURANT VALUES(4, 'Highland coffee', '1380 Quang Trung - Quận 12' ,'0345982112')");

        db.execSQL("INSERT INTO CUSTOMER VALUES('0982826756','admin', 'Nguyễn Bá Sơn', 'dân Nghệ An',17,'nữ')");

        db.execSQL("INSERT INTO PRODUCT VALUES(1, 'lẩu bò', 'thật ra không có thịt bò' ,349000,1)");
        db.execSQL("INSERT INTO PRODUCT VALUES(2, 'mực nướng', 'thật ra không có mực' ,149000,1)");
        db.execSQL("INSERT INTO PRODUCT VALUES(3, 'hàu nướng', 'thật ra không có hàu' ,249000,1)");
        db.execSQL("INSERT INTO PRODUCT VALUES(4, 'zú zê nướng', 'thật ra không có zê' ,190000,1)");

        db.execSQL("INSERT INTO PRODUCT VALUES(5, 'lẩu bò', 'thật ra không có thịt bò' ,349000,2)");
        db.execSQL("INSERT INTO PRODUCT VALUES(6, 'mực nướng', 'thật ra không có mực' ,149000,2)");
        db.execSQL("INSERT INTO PRODUCT VALUES(7, 'hàu nướng', 'thật ra không có hàu' ,249000,2)");
        db.execSQL("INSERT INTO PRODUCT VALUES(8, 'zú zê nướng', 'thật ra không có zê' ,190000,2)");

        db.execSQL("INSERT INTO PRODUCT VALUES(9, 'lẩu bò', 'thật ra không có thịt bò' ,349000,3)");
        db.execSQL("INSERT INTO PRODUCT VALUES(10, 'mực nướng', 'thật ra không có mực' ,149000,3)");
        db.execSQL("INSERT INTO PRODUCT VALUES(11, 'hàu nướng', 'thật ra không có hàu' ,249000,3)");
        db.execSQL("INSERT INTO PRODUCT VALUES(12, 'zú zê nướng', 'thật ra không có zê' ,190000,3)");

        db.execSQL("INSERT INTO PRODUCT VALUES(13, 'coffee trân châu đuồng đen', 'thật ra là đường phèn' ,349000,4)");
        db.execSQL("INSERT INTO PRODUCT VALUES(14, 'trà đào cam sả', 'thật ra là sả ớt' ,149000,4)");
        db.execSQL("INSERT INTO PRODUCT VALUES(15, 'matcha đá xay', '' ,249000,4)");
        db.execSQL("INSERT INTO PRODUCT VALUES(16, 'trà sữa không hành', 'bỏ hành ngon hơn' ,190000,4)");

        db.execSQL("INSERT INTO ORDERS VALUES(1, '30/07/2023 16:39', 'đã nhận', '219 tô ký - phường TMT - quận 12','0982826756',1)");
        db.execSQL("INSERT INTO ORDERS VALUES(2, '31/07/2023 12:39', 'đã nhận', 'CVPM Quang Trung - phường TMT - quận 12','0982826756',2)");
        db.execSQL("INSERT INTO ORDERS VALUES(3, '30/07/2023 16:39', 'đã nhận', '33 Lý Thường Kiệt - phường 10 - quận TB','0982826756',3)");
        db.execSQL("INSERT INTO ORDERS VALUES(4, '31/07/2023 12:39', 'đã nhận', '28A Nơ Trang Long - phường 3 - quận BT','0982826756',4)");

        db.execSQL("INSERT INTO DETAILORDER VALUES(1, 1, 349000,'112 Nguyễn Ảnh Thủ Q12', 1, 1)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(2, 1, 149000,'112 Nguyễn Ảnh Thủ Q12', 2, 1)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(3, 1, 249000,'112 Nguyễn Ảnh Thủ Q12', 7, 2)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(4, 1, 190000,'112 Nguyễn Ảnh Thủ Q12', 8, 2)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(5, 1, 249000,'112 Nguyễn Ảnh Thủ Q12', 11, 3)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(6, 1, 190000,'112 Nguyễn Ảnh Thủ Q12', 12, 3)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(7, 1, 249000,'112 Nguyễn Ảnh Thủ Q12', 15, 4)");
        db.execSQL("INSERT INTO DETAILORDER VALUES(8, 1, 190000,'112 Nguyễn Ảnh Thủ Q12', 16, 4)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS CUSTOMER");
            db.execSQL("DROP TABLE IF EXISTS ORDERS");
            db.execSQL("DROP TABLE IF EXISTS DETAILORDER");
            db.execSQL("DROP TABLE IF EXISTS PRODUCT");
            db.execSQL("DROP TABLE IF EXISTS RESTAURANT");
            onCreate(db);
        }
    }
}
