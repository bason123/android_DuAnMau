package com.example.appfood.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.DAO.RestaurantDAO;
import com.example.appfood.Fragment.HistoryDetailFragment;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.Order;
import com.example.appfood.Model.Restaurant;
import com.example.appfood.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
   private ArrayList<Order> listOrder;
    private Context context;
    private RestaurantDAO restaurantDAO;

    public HistoryAdapter(ArrayList<Order> listOrder, Context context, RestaurantDAO restaurantDAO) {
        this.listOrder = listOrder;
        this.context = context;
        this.restaurantDAO = restaurantDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_order, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.idOrder.setText(listOrder.get(position).getIdOrder()+"");
        holder.statusOrder.setText(listOrder.get(position).getStatus());
        String nameRestaurant = "";
        for(Restaurant restaurant : restaurantDAO.getListRestaurant()){
            if(restaurant.getIdRestaurant() == listOrder.get(position).getIdRestaurant()){
                nameRestaurant = restaurant.getNameRestaurant();
            }
        }
        holder.nameRestaurant.setText(nameRestaurant);
        holder.timeOrder.setText(listOrder.get(position).getDateOrder());

        holder.orderAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "dat moi 1 order co san pham giong nhu order nay", Toast.LENGTH_SHORT).show();
            }
        });
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy ra idOrder chuyển ra HistoryFragment
                ((MainActivity)context).replaceFragment(new HistoryDetailFragment(listOrder.get(position)));
            }
        });

    }


    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogoRestaurant;
        TextView idOrder, statusOrder, nameRestaurant, timeOrder;
        LinearLayout orderAgain,item;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoRestaurant = itemView.findViewById(R.id.imgLogoRestaurant);
            idOrder = itemView.findViewById(R.id.idOrder);
            statusOrder = itemView.findViewById(R.id.statusOrder);
            nameRestaurant = itemView.findViewById(R.id.nameRestaurant);
            timeOrder = itemView.findViewById(R.id.timeOrder);
            orderAgain = itemView.findViewById(R.id.orderAgain);
            item = itemView.findViewById(R.id.item);
        }
    }
}

