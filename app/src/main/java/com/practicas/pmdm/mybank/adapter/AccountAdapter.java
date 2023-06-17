package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountViewHolder> {

    private OnItemClickListener listener;

    List<Cuenta> listData;
    LayoutInflater inflater;
    Context context;

    public AccountAdapter(List<Cuenta> listData, Context context, OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.listData = listData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Init Inflater.
        inflater = LayoutInflater.from(parent.getContext());
        // Inflate View items.
        View listItemView = inflater.inflate(R.layout.list_row_cuenta, parent, false);
        // Init ViewHolder with View.
        return new AccountViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.render(listData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
                //Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

}
