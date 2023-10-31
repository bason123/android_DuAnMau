package com.example.appfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.DAO.DetailOrderDAO;
import com.example.appfood.DAO.OrdersDAO;
import com.example.appfood.Model.DetallOrder;
import com.example.appfood.Model.Order;
import com.example.appfood.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemHistoryAdapter extends RecyclerView.Adapter<ItemHistoryAdapter.ViewHolder> {
     ArrayList<DetallOrder> listDetailOrder;
     DetailOrderDAO detailOrderDAO;
     Context context;
     ArrayList<String> dataList;

    public ItemHistoryAdapter(ArrayList<DetallOrder> listDetailOrder, Context context, ArrayList<String> dataList) {
        this.listDetailOrder = listDetailOrder;
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_a_food_order_history, parent, false);
        detailOrderDAO = new DetailOrderDAO(parent.getContext());
        for (int i = 0; i < dataList.size(); i++) {
            int data = Integer.parseInt(dataList.get(i));
            listDetailOrder = detailOrderDAO.getListDetail(data);
        }
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Toast.makeText(context, ""+dataList, Toast.LENGTH_SHORT).show();
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        holder.tvQuanlity.setText(listDetailOrder.get(position).getQuantity()+"");
        holder.tvPrice.setText(currencyFormatVN.format(listDetailOrder.get(position).getPrice())+"");
        holder.nameProduct.setText(listDetailOrder.get(position).getNameProduct());
    }

    @Override
    public int getItemCount() {
        return listDetailOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuanlity, nameProduct, tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuanlity = itemView.findViewById(R.id.tvQuality);
            nameProduct = itemView.findViewById(R.id.nameProduct);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
