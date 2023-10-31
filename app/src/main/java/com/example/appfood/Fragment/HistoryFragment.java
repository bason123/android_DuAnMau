package com.example.appfood.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Adapter.HistoryAdapter;
import com.example.appfood.DAO.OrdersDAO;
import com.example.appfood.DAO.RestaurantDAO;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.Order;
import com.example.appfood.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView rcViewHistoryOrder;
    LinearLayoutManager linearLayoutManager;
    HistoryAdapter historyAdapter;
    ArrayList<Order> listOrder;
    OrdersDAO ordersDAO;
    RestaurantDAO restaurantDAO;
    ImageView BackHome;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        rcViewHistoryOrder = view.findViewById(R.id.rcViewHistoryOrder);
        linearLayoutManager = new LinearLayoutManager(getContext());
        ordersDAO = new OrdersDAO(getContext());
        restaurantDAO = new RestaurantDAO(getContext());


        listOrder = ordersDAO.getListOrders();
        historyAdapter = new HistoryAdapter(listOrder,getContext(),restaurantDAO);
        rcViewHistoryOrder.setLayoutManager(linearLayoutManager);
        rcViewHistoryOrder.setAdapter(historyAdapter);
        BackHome = view.findViewById(R.id.imageView);

        BackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).replaceFragment(new HomeFragment());
            }
        });

        return view;
    }
}
