package com.example.appfood.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Fragment.ShowDetailFragment;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.Product;
import com.example.appfood.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FoodAdapterVISIBLE extends RecyclerView.Adapter<FoodAdapterVISIBLE.ViewHolder> {
    ArrayList<Product> foodList;
    Context context;

    public FoodAdapterVISIBLE(ArrayList<Product> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_food2, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        holder.priceNewFood.setText(currencyFormatVN.format(foodList.get(position).getPriceProduct())+"");
        holder.priceOldFood.setText(currencyFormatVN.format(foodList.get(position).getPriceOld())+"");
        holder.nameFood.setText(foodList.get(position).getNameProduct());
        holder.km.setText(String.valueOf(foodList.get(position).getDescription()));
        holder.imgFood.setImageResource(foodList.get(position).getIdProduct());
        holder.nameRestaurant.setText(foodList.get(position).getNameRestaurant());
        holder.priceOldFood.setPaintFlags(holder.priceOldFood.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);

        holder.linearLayoutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).replaceFragment(new ShowDetailFragment(foodList.get(position)));
            }
        });
    }

    public void filterList(ArrayList<Product> filteredList, Context context) {
        foodList = filteredList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView priceNewFood, priceOldFood, nameFood, km, nameRestaurant;
        LinearLayout linearLayoutFood;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceNewFood = itemView.findViewById(R.id.priceNewFood);
            priceOldFood = itemView.findViewById(R.id.priceOldFood);
            nameFood = itemView.findViewById(R.id.nameFood);
            km = itemView.findViewById(R.id.km);
            imgFood = itemView.findViewById(R.id.imgFood);
            nameRestaurant = itemView.findViewById(R.id.nameRestaurant);
            linearLayoutFood = itemView.findViewById(R.id.linearLayoutFood);
        }
    }
}
