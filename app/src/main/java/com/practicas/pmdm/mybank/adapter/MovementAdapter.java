package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.Collections;
import java.util.List;

public class MovementAdapter extends RecyclerView.Adapter<MovementViewHolder> {

    private List<Movimiento> listMovement;
    private LayoutInflater inflater;
    private Context context;

    public MovementAdapter(List<Movimiento> listMovement, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.listMovement = listMovement;
    }

    @NonNull
    @Override
    public MovementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = inflater.inflate(R.layout.list_row_movement, parent, false);
        return new MovementViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovementViewHolder holder, int position) {
        holder.render(listMovement.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovement.size();
    }

}
