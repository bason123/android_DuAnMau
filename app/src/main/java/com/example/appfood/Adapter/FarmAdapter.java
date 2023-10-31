package com.example.appfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appfood.Model.farm;
import com.example.appfood.R;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.ViewHolder> {
    ArrayList<farm> farmList;
    Context context;

    public FarmAdapter(ArrayList<farm> FoodDomains, Context context) {
        this.farmList = FoodDomains;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_farm, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        holder.priceNew.setText(currencyFormatVN.format(farmList.get(position).getPriceNew())+"");
        holder.priceOld.setText(currencyFormatVN.format(farmList.get(position).getPriceOld())+"");
        holder.namebo.setText(farmList.get(position).getNamePoduct());
        holder.kg.setText(String.valueOf(farmList.get(position).getKg()));
        holder.imgbo.setImageResource(farmList.get(position).getImg());
        holder.priceOld.setPaintFlags(holder.priceOld.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);

    }


    @Override
    public int getItemCount() {
        return farmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgbo, imgchu;
        TextView priceNew, priceOld, namebo, kg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceNew = itemView.findViewById(R.id.priceNew);
            priceOld = itemView.findViewById(R.id.priceOld);
            namebo = itemView.findViewById(R.id.namebo);
            kg = itemView.findViewById(R.id.kg);
            imgbo = itemView.findViewById(R.id.imgbo);
            imgchu = itemView.findViewById(R.id.imgchu);
        }
    }
}
