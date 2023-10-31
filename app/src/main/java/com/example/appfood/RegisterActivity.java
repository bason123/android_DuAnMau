package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appfood.DAO.CustomerDAO;
import com.example.appfood.Model.Customer;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, nameCustomer, gender, password, passwordRetype, age, addressCustomer;
    private Button btnRegister;
    private CustomerDAO customerDAO;
    private ArrayList<Customer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_register);
        username = findViewById(R.id.username);
        nameCustomer = findViewById(R.id.nameCustomer);
        gender = findViewById(R.id.gender);
        password = findViewById(R.id.password);
        passwordRetype = findViewById(R.id.passwordRetype);
        btnRegister = findViewById(R.id.btnRegister);
        age = findViewById(R.id.age);
        addressCustomer = findViewById(R.id.addressCustomer);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = username.getText().toString();
                String name = nameCustomer.getText().toString();
                String gioiTinh = gender.getText().toString();
                String pass = password.getText().toString();
                String passRetype = passwordRetype.getText().toString();
                String tuoi1 = age.getText().toString();
                String diaChi = addressCustomer.getText().toString();
                customerDAO = new CustomerDAO(RegisterActivity.this);

                if (tuoi1.isEmpty()) {
                    // Trường nhập tuổi rỗng, xử lý thông báo lỗi tương ứng.
                    Toast.makeText(RegisterActivity.this, "Điền đẩy đủ thông tin", Toast.LENGTH_SHORT).show();
                 } else {
                    try {
                        int tuoi = Integer.parseInt(tuoi1);
                        if (tuoi >= 1 && tuoi <= 120) {
                            if (phone.length() > 0 && name.length() > 0 && pass.length() > 0 && passRetype.length() > 0 && gioiTinh.length()>0 && diaChi.length()>0) {
                                Customer customer = new Customer(phone, pass, name, diaChi, tuoi, gioiTinh);
                                if(pass.equalsIgnoreCase(passRetype)) {
                                    if (customerDAO.checkTk(phone)) {
                                        customerDAO.addCustomer(customer);
                                        list = customerDAO.getListCustomer();
                                        finish();
                                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(RegisterActivity.this, LogInActivity.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(RegisterActivity.this, "Nhập lại sai mật khẩu", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(RegisterActivity.this, "Điền đẩy đủ thông tin", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(RegisterActivity.this, "Tuổi lớn hơn 1", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(RegisterActivity.this, "Tuổi là một số", Toast.LENGTH_SHORT).show();
                    }
                }
           }
        });
    }
}