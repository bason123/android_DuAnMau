package com.example.appfood.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Fragment.ShopFragment;
import com.example.appfood.Fragment.ShowDetailFragment;
import com.example.appfood.MainActivity;
import com.example.appfood.Model.Product;
import com.example.appfood.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {
    private ArrayList<Product> listProduct;
    private Context context;
    private int numberOrder = 1, totalSoLuong = 0;
    private OnAdapterButtonClickListener listener;
    private Product product;


    public ListProductAdapter(ArrayList<Product> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context = context;
    }

    public interface OnAdapterButtonClickListener {
        void onButtonClicked();
    }
    public void setListener(OnAdapterButtonClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_a_food_order, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatVN = NumberFormat.getCurrencyInstance(vietnamLocale);
        holder.nameFood.setText(listProduct.get(position).getNameProduct());
        holder.priceFood.setText(currencyFormatVN.format(listProduct.get(position).getPriceProduct())+"");
        holder.soLuong.setText(listProduct.get(position).getSoLuong()+"");
        holder.tonggia.setText(currencyFormatVN.format((listProduct.get(position).getSoLuong()*listProduct.get(position).getPriceProduct()))+"");

        holder.giamSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listProduct.get(position).getSoLuong()>1){
                    listProduct.get(position).setSoLuong(listProduct.get(position).getSoLuong()-1);
                    notifyDataSetChanged();
                    ((MainActivity)context).replaceFragment(new ShopFragment());
                    for(Product product : listProduct){
                        totalSoLuong += product.getSoLuong();
                    }
                    ((MainActivity)context).tvTest.setText(totalSoLuong+"");
                }

            }
        });
        holder.tangSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listProduct.get(position).setSoLuong(listProduct.get(position).getSoLuong()+1);
                notifyDataSetChanged();
                ((MainActivity)context).replaceFragment(new ShopFragment());
                for(Product product : listProduct){
                    totalSoLuong += product.getSoLuong();
                }
                ((MainActivity)context).tvTest.setText(totalSoLuong+"");
            }
        });

        final int currentPosition = position;

            holder.remoreProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentPosition >= 0 && currentPosition < listProduct.size()) {
                        listProduct.remove(currentPosition);
                        for(Product product : listProduct){
                            totalSoLuong += product.getSoLuong();
                        }
                        ((MainActivity)context).tvTest.setText(totalSoLuong+"");
                        notifyDataSetChanged();
                        ((MainActivity)context).replaceFragment(new ShopFragment());
                        if (listener != null) {
                            Toast.makeText(context, ""+listener, Toast.LENGTH_SHORT).show();
                            listener.onButtonClicked(); // Gửi sự kiện khi nút trong adapter được ấn
                        }
                    }
                }
            });
    }


    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameFood, priceFood, soLuong, tonggia;
        Button tangSoLuong, giamSoLuong, remoreProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.nameFood);
            priceFood = itemView.findViewById(R.id.priceFood);
            tangSoLuong = itemView.findViewById(R.id.tangSoLuong);
            giamSoLuong = itemView.findViewById(R.id.giamSoLuong);
            soLuong = itemView.findViewById(R.id.soLuong);
            tonggia = itemView.findViewById(R.id.tonggia);
            remoreProduct = itemView.findViewById(R.id.remoreProduct);
        }
    }



}

