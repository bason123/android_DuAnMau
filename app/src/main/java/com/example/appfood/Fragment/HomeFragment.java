package com.example.appfood.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.appfood.Adapter.FoodAdapter;
import com.example.appfood.Adapter.FoodAdapterVISIBLE;
import com.example.appfood.Adapter.ImageAdapter;
import com.example.appfood.Adapter.PromotionAdapter;
import com.example.appfood.Model.Image;
import com.example.appfood.Model.Product;
import com.example.appfood.Model.Promotion;
import com.example.appfood.R;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ImageAdapter imageAdapter;
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewFarmList, recyclerViewFoodList, recyclerViewPromotionList;
    private TextView search;
    private FoodAdapter foodAdapter;
    private FoodAdapterVISIBLE foodAdapterVISIBLE;
    private ArrayList<Product> foodlist;
    private ScrollView scrollView;
    private RecyclerView rcViewSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        search = view.findViewById(R.id.search);
        scrollView = view.findViewById(R.id.scrollView);

        recyclerViewFarmList = view.findViewById(R.id.recyclerViewFarm);
        recyclerViewFoodList = view.findViewById(R.id.recyclerViewFood);
        recyclerViewPromotionList = view.findViewById(R.id.recyclerViewPromotion);
        rcViewSearch = view.findViewById(R.id.rcViewSearch);

        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        imageAdapter = new ImageAdapter((getContext()), getListImg());
        viewPager.setAdapter(imageAdapter);

        circleIndicator.setViewPager(viewPager);
        imageAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        recyclerViewFarm();
        recyclerViewFood();
        recyclerViewPromotion();
        recyclerViewFood2();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                scrollView.setVisibility(View.GONE);
                rcViewSearch.setVisibility(View.VISIBLE);
                filter(s.toString());
            }
        });

        return view;
    }

    private ArrayList<Image> getListImg(){
        ArrayList<Image> list = new ArrayList<>();
        list.add(new Image(R.drawable.chupthucandep1));
        list.add(new Image(R.drawable.chupthucandepsg));
        list.add(new Image(R.drawable.chupthucandep2));
        list.add(new Image(R.drawable.chupthucandep3));
        list.add(new Image(R.drawable.chupthucandep4));

        return list;
    }

        private void recyclerViewFarm() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFarmList.setLayoutManager(linearLayoutManager);

            foodlist = new ArrayList<>();
            foodlist.add(new Product(R.drawable.images10, 30000, 25000 ,"Bún bò huế","Cô bé - Quận 12", "1.3km-", "Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));
            foodlist.add(new Product(R.drawable.images11, 30000, 25000 ,"Bún đậu hũ","34 Tô Ký - Quận 12", "4.3km-","Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));
            foodlist.add(new Product(R.drawable.images12, 40000, 20000 ,"Bún giò chả","Phạm Văn Đồng - Gò Vấp", "5.3km-","Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));
            foodlist.add(new Product(R.drawable.images13, 35000, 23000 ,"Bún thịt nướng", "Đông bắc - Quận 12", "2.3km-","Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));
            foodlist.add(new Product(R.drawable.images14, 30000, 20000 ,"Bún thập cẩm huế", "Ăn là nghiền - Gò vấp","4.3km-","Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));
            foodlist.add(new Product(R.drawable.images15, 50000, 30000 ,"Miến thịt gà", "Năm ae - Gò vấp", "4.3km-","Mô tả: Tô bún nhiều thịt ngon\n giá danh cho sinh viên"));

            foodAdapter = new FoodAdapter(foodlist, getContext());
            recyclerViewFarmList.setAdapter(foodAdapter);
    }


    private void recyclerViewFood(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFoodList.setLayoutManager(linearLayoutManager);

        foodlist = new ArrayList<>();
        foodlist.add(new Product(R.drawable.imgfood1, 30000, 25000 ,"Cơm sườn trứng","Cô bé - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood2, 30000, 25000 ,"Cơm sườn chả","34 Tô Ký - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood3, 40000, 20000 ,"Cơm cà ri","Phạm Văn Đồng - Gò Vấp", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood9, 35000, 23000 ,"Cơm chiên hải sản", "Đông bắc - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood5, 30000, 20000 ,"Cơm trộn", "Ăn là nghiền - Gò vấp","4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood6, 50000, 30000 ,"Cơm thịt chiên", "Năm ae - Gò vấp", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood8, 35000, 25000 ,"Cơm cuộn", "Hai chị em - Gò vấp","4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));

        foodAdapter = new FoodAdapter(foodlist, getContext());
        recyclerViewFoodList.setAdapter(foodAdapter);
    }

    private void recyclerViewFood2(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcViewSearch.setLayoutManager(linearLayoutManager);

        foodlist = new ArrayList<>();
        foodlist.add(new Product(R.drawable.imgfood1, 30000, 25000 ,"Cơm sườn trứng","Cô bé - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood2, 30000, 25000 ,"Cơm sườn chả","34 Tô Ký - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood3, 40000, 20000 ,"Cơm cà ri","Phạm Văn Đồng - Gò Vấp", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood9, 35000, 23000 ,"Cơm chiên hải sản", "Đông bắc - Quận 12", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood5, 30000, 20000 ,"Cơm trộn", "Ăn là nghiền - Gò vấp","4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood6, 50000, 30000 ,"Cơm thịt chiên", "Năm ae - Gò vấp", "4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodlist.add(new Product(R.drawable.imgfood8, 35000, 25000 ,"Cơm cuộn", "Hai chị em - Gò vấp","4.3km-","Mô Tả SP: Cơm ngon nhiều thit, nhiều trứng\n nhiều cơm giá rẻ "));
        foodAdapterVISIBLE = new FoodAdapterVISIBLE(foodlist, getContext());
        rcViewSearch.setAdapter(foodAdapterVISIBLE);
    }

    private void recyclerViewPromotion(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPromotionList.setLayoutManager(linearLayoutManager);

        ArrayList<Promotion> promotionlist = new ArrayList<>();
        promotionlist.add(new Promotion("Khuyến mãi", R.drawable.ministop, "MINESTOP" ,"25 Phút - 4,4 km", "Convenience - Gà rán - Burger", "Ưu đãi đến 25%", "Mặt hàng này giảm giá"));
        promotionlist.add(new Promotion("Khuyến mãi", R.drawable.ministop1, "KINESTOP" ,"25 Phút - 4,4 km", "Convenience - Gà rán - Burger", "Ưu đãi đến 25%", "Mặt hàng này giảm giá"));
        promotionlist.add(new Promotion("Khuyến mãi", R.drawable.ministop2, "VinMart" ,"15 Phút - 2,4 km", "Convenience - Gà rán - Burger", "Ưu đãi đến 25%", "Mặt hàng này giảm giá"));
        promotionlist.add(new Promotion("Khuyến mãi", R.drawable.ministop, "MINESTOP" ,"25 Phút - 4,4 km", "Convenience - Gà rán - Burger", "Ưu đãi đến 25%", "Mặt hàng này giảm giá"));
        PromotionAdapter promotionAdapter = new PromotionAdapter(promotionlist, getContext());
        recyclerViewPromotionList.setAdapter(promotionAdapter);
    }

    private void filter(String text) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcViewSearch.setLayoutManager(linearLayoutManager);
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product item : foodlist) {
            if (removeDiacriticalMarks(item.getNameProduct().toLowerCase(Locale.getDefault()))
                    .contains(removeDiacriticalMarks(text.toLowerCase(Locale.getDefault())))) {
                filteredList.add(item);

            }
        }
        foodAdapterVISIBLE.filterList(filteredList, getContext());
        rcViewSearch.setAdapter(foodAdapterVISIBLE);
    }

    private String removeDiacriticalMarks(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");// loại bỏ các dấu
        return pattern.matcher(normalized).replaceAll("").replaceAll("đ", "d");
    }
}
