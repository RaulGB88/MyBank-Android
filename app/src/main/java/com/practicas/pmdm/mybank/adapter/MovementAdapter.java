package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.List;

public class MovementAdapter extends RecyclerView.Adapter<MovementViewHolder> {

    private OnItemClickListener listener;
    private List<Movimiento> listData;
    private LayoutInflater inflater;
    private Context context;

    public MovementAdapter(List<Movimiento> listData, Context context, OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.listData = listData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Init Inflater.
        inflater = LayoutInflater.from(parent.getContext());
        // Inflate View items.
        View listItemView = inflater.inflate(R.layout.list_row_movement, parent, false);
        // Init ViewHolder with View.
        return new MovementViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovementViewHolder holder, int position) {
        holder.render(listData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

}
