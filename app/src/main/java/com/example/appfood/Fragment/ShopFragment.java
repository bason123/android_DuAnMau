package com.example.appfood.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Adapter.ListProductAdapter;
import com.example.appfood.DAO.DetailOrderDAO;
import com.example.appfood.DAO.OrdersDAO;
import com.example.appfood.DAO.ProductDAO;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.DetallOrder;
import com.example.appfood.Model.Image;
import com.example.appfood.Model.Order;
import com.example.appfood.Model.Product;
import com.example.appfood.Model.Restaurant;
import com.example.appfood.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ShopFragment extends Fragment {
    private RecyclerView rcViewListDetail;
    private ArrayList<Product> listProduct;
    private int total=0, totalSoLuong = 0;
    private TextView totalTamTinh, giamgia, tongHoaDon, themMon, datDon;
    private ImageView BackHome;
    private ArrayList<Order> listOrder;
    private OrdersDAO ordersDAO;
    private DetallOrder detallOrder;
    private DetailOrderDAO detailOrderDAO;
    ListProductAdapter listProductAdapter;
    ProductDAO productDAO;
    Product product;
//    private OnDataUpdateListener listener;
//
//
//    public interface OnDataUpdateListener {
//        void onDataUpdated(int newData); // Truyền dữ liệu cần chuyển từ Fragment sang Activity
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        rcViewListDetail = view.findViewById(R.id.rcViewListDetail);
        listProduct = new ArrayList<>();
        listProduct = ((MainActivity)getContext()).getGioHang();
        totalTamTinh = view.findViewById(R.id.totalTamTinh);
        giamgia = view.findViewById(R.id.giamGia);
        tongHoaDon = view.findViewById(R.id.tongHoaDon);
        themMon = view.findViewById(R.id.themMon);
        datDon = view.findViewById(R.id.datDon);
        ordersDAO = new OrdersDAO(getContext());
        detailOrderDAO = new DetailOrderDAO(getContext());
        productDAO = new ProductDAO(getContext());
        BackHome = view.findViewById(R.id.ShopBackHome);


        BackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).replaceFragment(new HomeFragment());
            }
        });

        for(Product product : listProduct){
            total += (product.getPriceProduct() * product.getSoLuong());
//            totalSoLuong += product.getSoLuong();
        }

//        sendDataToActivity(totalSoLuong);
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        totalTamTinh.setText(currencyFormatVN.format(total)+"");
        int totalGiamGia = Integer.parseInt(giamgia.getText().toString());
        if(listProduct.size()>0){
            tongHoaDon.setText(currencyFormatVN.format(total-totalGiamGia)+"");
        }
        themMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).replaceFragment(new HomeFragment());
            }
        });


        datDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1; // Tháng được đánh số từ 0 - 11, nên cộng thêm 1 để lấy tháng thực tế
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                String date = dayOfMonth+"/"+month+"/"+year+"  "+ hour +":" + minute;
                String phone = "";
                for(Order order : ordersDAO.getListOrders()){
                    phone = order.getPhoneCustomer();
                }
                String address = "";
                int idOrder = 0;
                for(Order order : ordersDAO.getListOrders()){
                    address = order.getAddressCustomer();
                }

                Order order = new Order(date, "đã nhận", address, phone, 1);
                ordersDAO.addOrder(order);

                idOrder = (ordersDAO.getListOrders()).get((ordersDAO.getListOrders().size())-1).getIdOrder();
                for (Product product: listProduct) {
                    detallOrder = new DetallOrder(idOrder, product.getIdProduct(),product.getSoLuong(), product.getPriceProduct(),product.getPriceOld());
                    detailOrderDAO.addDetallOrder(detallOrder);
                    listProduct.clear();
                    Toast.makeText(getContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                    ((MainActivity)getContext()).tvTest.setText("0");
                    ((MainActivity)getContext()).replaceFragment(new HomeFragment());
                }
            }
        });

        recyclerViewFood();
        return view;
    }

    private void recyclerViewFood(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false);
        rcViewListDetail.setLayoutManager(linearLayoutManager);

        listProductAdapter = new ListProductAdapter(listProduct, getContext());
        rcViewListDetail.setAdapter(listProductAdapter);
    }


//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof OnDataUpdateListener) {
//            listener = (OnDataUpdateListener) context;
//        } else {
//            throw new ClassCastException(context.toString() + " must implement OnDataUpdateListener");
//        }
//    }
//    private void sendDataToActivity(int data) {
//        if (listener != null) {
//            listener.onDataUpdated(data);
//        }
//    }

}
