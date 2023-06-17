package com.practicas.pmdm.mybank.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Movimiento;

public class MovementViewHolder extends RecyclerView.ViewHolder {

    TextView tvIdMovement;
    TextView tvtipo;
    TextView tvFechaOperacion;
    TextView tvDescripcion;
    TextView tvImporte;
    TextView tvNumeroCuentaOrigen;
    TextView tvNumeroCuentaDestino;

    // Constructor
    public MovementViewHolder(View itemView) {

        super(itemView);

        // 4. Get TextView rows / atributtes (Cast to TextView).
        tvIdMovement = (TextView) itemView.findViewById(R.id.tvIdMovement);
        tvtipo = (TextView) itemView.findViewById(R.id.tvTipo);
        tvFechaOperacion = (TextView) itemView.findViewById(R.id.tvFechaOperacion);
        tvDescripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
        tvImporte = (TextView) itemView.findViewById(R.id.tvImporte);
        tvNumeroCuentaOrigen = (TextView) itemView.findViewById(R.id.tvNumeroCuentaOrigen);
        tvNumeroCuentaDestino = (TextView) itemView.findViewById(R.id.tvNumeroCuentaDestino);
    }

    public void render(Movimiento movement) {

        // 6. Set the object atributtes to TextView (Set toi TextView).
        tvIdMovement.setText(String.valueOf(movement.getId()));
        tvtipo.setText(String.valueOf(movement.getTipo()));
        tvFechaOperacion.setText(String.valueOf(movement.getFechaOperacion()));
        tvDescripcion.setText(movement.getDescripcion());
        tvImporte.setText(String.valueOf(movement.getImporte()));
        tvNumeroCuentaOrigen.setText(movement.getCuentaOrigen().getNumeroCuenta());
        tvNumeroCuentaDestino.setText(movement.getCuentaDestino().getNumeroCuenta());
    }

}
