package com.example.appfood.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Adapter.FoodAdapter;
import com.example.appfood.Adapter.ListProductAdapter;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.Product;
import com.example.appfood.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ShowDetailFragment extends Fragment implements ListProductAdapter.OnAdapterButtonClickListener {

    private ImageView img;
    private TextView soLuong, giacu, giamoi, tong, addcart, nameFood, mota, soLuongMon;
    private Button giam, tang;
    private int numberOrder = 1;
    private int totalCart = 0, totalSoLuong = 0;
    private RecyclerView recyclerViewThuongDuocMua;
    private int total=0;
    private int giamoi1;
    private ArrayList<Product> listProduct;
    public static final String TAG = "PersonListFragment";
//    private Cart cart;
    private LinearLayout giohang;
    private Product productDetail;
    private OnAdapterButtonClickListener listener;


    public ShowDetailFragment(Product productDetail) {
        this.productDetail = productDetail;
    }

    public interface OnAdapterButtonClickListener {
        void onDataUpdated(int newData); // Truyền dữ liệu cần chuyển từ Fragment sang Activity
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_product, container, false);
        giam = view.findViewById(R.id.giam);
        tang = view.findViewById(R.id.tang);
        soLuong = view.findViewById(R.id.soLuong);
        giacu = view.findViewById(R.id.giacu);
        giamoi = view.findViewById(R.id.gia);
        tong = view.findViewById(R.id.tong);
        addcart = view.findViewById(R.id.addcart);
        nameFood = view.findViewById(R.id.nameFood);
        giohang = view.findViewById(R.id.giohang);
        img = view.findViewById(R.id.img);
        mota = view.findViewById(R.id.mota);
        soLuongMon = view.findViewById(R.id.soLuongMon);
        listProduct = ((MainActivity)getContext()).getGioHang();

        recyclerViewThuongDuocMua = view.findViewById(R.id.recyclerViewThuongDuocMua);

        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        nameFood.setText(productDetail.getNameProduct());
        giamoi.setText(currencyFormatVN.format(productDetail.getPriceProduct())+"");
        giacu.setText(currencyFormatVN.format(productDetail.getPriceOld())+"");
        img.setImageResource(productDetail.getIdProduct());
        mota.setText(productDetail.getDescribe());

        ListProductAdapter adapter = new ListProductAdapter(listProduct, getContext());
        adapter.setListener(this);

        giacu.setPaintFlags(giacu.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);

//        cart = new Cart();
        soLuongMon.setText(listProduct.size()+"");

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean existAlready = false;
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getNameProduct().equals(productDetail.getNameProduct())){
                        existAlready = true;
                        break;
                    }
                }

                if (existAlready == true) {
                    Toast.makeText(ShowDetailFragment.this.getContext(), "Đã có sản phẩm trong giỏ hàng", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                        int soluong = Integer.parseInt(soLuong.getText().toString());
                        productDetail.setSoLuong(soluong);
                        listProduct.add(productDetail);
                        ((MainActivity)getContext()).setGioHang(listProduct);
                        soLuongMon.setText(listProduct.size()+"");
                        Toast.makeText(ShowDetailFragment.this.getContext(), "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();

                }
                tong.setText(currencyFormatVN.format(productDetail.getPriceProduct())+"");
                for(Product product : listProduct){
                    totalCart += (product.getPriceProduct() * product.getSoLuong());
                    totalSoLuong += product.getSoLuong();
                }
                tong.setText(currencyFormatVN.format(totalCart)+"");
//                ((MainActivity) getActivity()).reloadPage();

                sendDataToActivity(totalSoLuong);
            }
        });

        numberQuantity();
        recyclerViewFarm();
        return view;
    }

    public void numberQuantity(){
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        giamoi1 = Integer.parseInt((giamoi.getText().toString()).replaceAll("[^0-9]", ""));
        giamoi.setText(String.valueOf(currencyFormatVN.format(giamoi1)));
        soLuong.setText(String.valueOf(numberOrder));

        tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                soLuong.setText(String.valueOf(numberOrder));
                int tonggia = giamoi1 * numberOrder;
//                tong.setText(String.valueOf(tonggia));
            }
        });
        giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder>1){
                    numberOrder = numberOrder -1;
                    soLuong.setText(String.valueOf(numberOrder));
                    int tonggia = giamoi1 * numberOrder;
//                    tong.setText(String.valueOf(tonggia));
                }
            }
        });

    }

    private void recyclerViewFarm() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewThuongDuocMua.setLayoutManager(linearLayoutManager);

        ArrayList<Product>foodlist = new ArrayList<>();
        foodlist.add(new Product(R.drawable.imgfood1, 30000, 25000 ,"Cơm sườn trứng","Cô bé - Quận 12", "4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood2, 30000, 25000 ,"Cơm sườn chả","34 Tô Ký - Quận 12", "4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood3, 40000, 20000 ,"Cơm cà ri","Phạm Văn Đồng - Gò Vấp", "4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood9, 35000, 23000 ,"Cơm chiên hải sản", "Đông bắc - Quận 12", "4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood5, 30000, 20000 ,"Cơm trộn", "Ăn là nghiền - Gò vấp","4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood6, 50000, 30000 ,"Cơm thịt chiên", "Năm ae - Gò vấp", "4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));
        foodlist.add(new Product(R.drawable.imgfood8, 35000, 25000 ,"Cơm cuộn", "Hai chị em - Gò vấp","4.3km-","cơm ngon nhiều thit\n nhiều cơm giá rẻ"));

        FoodAdapter foodAdapter = new FoodAdapter(foodlist, getContext());
        recyclerViewThuongDuocMua.setAdapter(foodAdapter);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //    public ArrayList<Food> getProduct(){
//        return listProduct;
//    }
//        private void viewCart() {
//            Intent intent = new Intent(ShowDetailFragment.this.getContext(), ShopFragment.class);
//            intent.putExtra("CART", cart);
//            start(intent);
//        }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnAdapterButtonClickListener) {
            listener = (OnAdapterButtonClickListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnDataUpdateListener");
        }
    }
    private void sendDataToActivity(int data) {
        if (listener != null) {
            listener.onDataUpdated(data);
        }
    }

    public void onButtonClicked() {
        ((MainActivity)getContext()).replaceFragment(new ShowDetailFragment(productDetail));
    }
}
