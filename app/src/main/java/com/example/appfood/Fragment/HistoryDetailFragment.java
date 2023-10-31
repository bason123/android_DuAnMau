package com.example.appfood.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Adapter.HistoryAdapter;
import com.example.appfood.Adapter.ItemHistoryAdapter;
import com.example.appfood.DAO.DetailOrderDAO;
import com.example.appfood.DAO.OrdersDAO;
import com.example.appfood.DAO.RestaurantDAO;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.DetallOrder;
import com.example.appfood.Model.Order;
import com.example.appfood.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryDetailFragment extends Fragment {

    TextView idOrder,nameRestaurant,status,addressStart,addressTarget,feeShip, totalPrice,total,btnContactUs,orderAgain;
    View view;
    RecyclerView rcViewListDetail;
    ImageView imageView;

    private Order orderTarget;
    private DetailOrderDAO detailOrderDAO;
    private ArrayList<DetallOrder> listDetailOrder;
    private ArrayList<String> dataList;
    private ItemHistoryAdapter myAdapter;
    private int totalDon = 0;

    public HistoryDetailFragment(Order orderTarget) {
        this.orderTarget = orderTarget;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history_detail, container, false);

        mapping(view);


        nameRestaurant.setText(orderTarget.getDateOrder());
        listDetailOrder = detailOrderDAO.getListDetail(orderTarget.getIdOrder());
        dataList = new ArrayList<>();
        String idOrder = "";
        for(DetallOrder d : listDetailOrder){
            idOrder = d.getIdOrder()+"";
            dataList.add(idOrder);
            break;
        }
        for(DetallOrder d : listDetailOrder){
            totalDon += (d.getPrice());
        }
        total.setText(totalDon+"VND");
        status.setText(orderTarget.getStatus());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).replaceFragment(new HistoryFragment());
            }
        });

       RecyclerViewListDetailHistory();
        return view;
    }

    private void mapping(View view){
        idOrder = view.findViewById(R.id.idOrder);
        nameRestaurant = view.findViewById(R.id.nameRestaurant);
        status = view.findViewById(R.id.status);
        addressStart = view.findViewById(R.id.addressStart);
        addressTarget = view.findViewById(R.id.addressTarget);
        totalPrice = view.findViewById(R.id.total);
        total = view.findViewById(R.id.total);
        btnContactUs = view.findViewById(R.id.btnContactUs);
        orderAgain = view.findViewById(R.id.orderAgain);
        detailOrderDAO = new DetailOrderDAO(getContext());
        listDetailOrder = new ArrayList<>();
        rcViewListDetail = view.findViewById(R.id.rcViewListDetail);
        imageView = view.findViewById(R.id.imageView);
    }

    private void RecyclerViewListDetailHistory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcViewListDetail.setLayoutManager(linearLayoutManager);

        ItemHistoryAdapter itemHistoryAdapter = new ItemHistoryAdapter(listDetailOrder, getContext(), dataList);
        rcViewListDetail.setAdapter(itemHistoryAdapter);
    }
}
