package com.example.appfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appfood.Fragment.HistoryFragment;
import com.example.appfood.Fragment.HomeFragment;
import com.example.appfood.Fragment.ShopFragment;
import com.example.appfood.Fragment.ShowDetailFragment;
import com.example.appfood.Model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShowDetailFragment.OnAdapterButtonClickListener {
    private BottomNavigationView navigationView;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private ArrayList<Product> gioHang;
    private int totalSoLuong;
    public TextView tvTest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.view_frame, fragment).commit();
        navigationView = findViewById(R.id.bottom_navi);
        gioHang = new ArrayList<>();

        //test

        BottomNavigationMenuView navigationMenuView =
                (BottomNavigationMenuView) navigationView.getChildAt(0);

        View view = navigationMenuView.getChildAt(1);

        BottomNavigationItemView itemView = (BottomNavigationItemView) view;

        View cart_badge = LayoutInflater.from(this)
                .inflate(R.layout.item_cart,
                        navigationMenuView, false);

        itemView.addView(cart_badge);
        tvTest = itemView.findViewById(R.id.cart_badge);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_home:
                        fragment =  new HomeFragment();
                        break;
                    case R.id.item_Shopp:
                        fragment = new ShopFragment();

                        break;
                    case R.id.item_history:
                        fragment = new HistoryFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.view_frame, fragment).commit();
                return true;
            }
        });


    }
    public void replaceFragment(Fragment fragment){
            fragmentManager.beginTransaction().replace(R.id.view_frame, fragment).commit();
    }

    public ArrayList<Product> getGioHang() {
        return gioHang;
    }

    public void setGioHang(ArrayList<Product> gioHang) {
        this.gioHang = gioHang;
    }
    public void reloadPage(){
        gioHang = new ArrayList<>();
    }
       public void onDataUpdated(int newData) {
        tvTest.setText(newData+""); // Gắn dữ liệu vào TextView
      }
}