package com.example.appfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfood.DAO.CustomerDAO;

public class LogInActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnlogin;
    private CheckBox checkBox;
    private TextView logRegister;
    private CustomerDAO customerDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);
        checkBox = findViewById(R.id.checkbox);
        logRegister = findViewById(R.id.logRegister);
        customerDAO = new CustomerDAO(LogInActivity.this);
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("isRemember", false);
        if(check){
            String user = sharedPreferences.getString("user","");
            String pass = sharedPreferences.getString("pass","");
            checkBox.setChecked(check);
            username.setText(user);
            password.setText(pass);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.length()>0 && pass.length()>0){
                    if(customerDAO.checkDN(user,pass)){
                        boolean isRemember = checkBox.isChecked();
                        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                        SharedPreferences.Editor editor =sharedPreferences.edit();
                        editor.putBoolean("isRemember", isRemember);
                        editor.putString("user",user);
                        editor.putString("pass",pass);
                        editor.apply();
                        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LogInActivity.this, "Sai username hoặc password", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LogInActivity.this, "Điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        logRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}