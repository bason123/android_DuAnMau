package com.example.appfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Model.Promotion;
import com.example.appfood.R;

import java.util.ArrayList;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {
    ArrayList<Promotion> promotionList;
    Context context;

    public PromotionAdapter(ArrayList<Promotion> promotionList, Context context) {
        this.promotionList = promotionList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_promotion, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namePromotion.setText(promotionList.get(position).getNamePromation());
        holder.nameStore.setText(promotionList.get(position).getNameStore());
        holder.promotion.setText(promotionList.get(position).getPromation());
        holder.namePromotion.setText(promotionList.get(position).getNamePromation());
        holder.mitune.setText(String.valueOf(promotionList.get(position).getMitune()));
        holder.mathanggiam.setText(promotionList.get(position).getMathanggiam());
        holder.imgPromotion.setImageResource(promotionList.get(position).getImgPromotion());

    }


    @Override
    public int getItemCount() {
        return promotionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPromotion;
        TextView nameStore, promotion, namePromotion, ratePromotion, mitune, mathanggiam;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameStore = itemView.findViewById(R.id.nameStore);
            promotion = itemView.findViewById(R.id.promotion);
            namePromotion = itemView.findViewById(R.id.namePromotion);
            ratePromotion = itemView.findViewById(R.id.ratePromotion);
            mitune = itemView.findViewById(R.id.mitune);
            mathanggiam = itemView.findViewById(R.id.mathanggiam);
            imgPromotion = itemView.findViewById(R.id.imgPromotion);
        }
    }
}
