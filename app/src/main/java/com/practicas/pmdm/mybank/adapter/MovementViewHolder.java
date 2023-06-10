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
    public MovementViewHolder(View listItemView) {

        super(listItemView);

        // 4. Get TextView rows / atributtes (Cast to TextView).
        tvIdMovement = (TextView) listItemView.findViewById(R.id.tvIdMovement);
        tvtipo = (TextView) listItemView.findViewById(R.id.tvTipo);
        tvFechaOperacion = (TextView) listItemView.findViewById(R.id.tvFechaOperacion);
        tvDescripcion = (TextView) listItemView.findViewById(R.id.tvDescripcion);
        tvImporte = (TextView) listItemView.findViewById(R.id.tvImporte);
        tvNumeroCuentaOrigen = (TextView) listItemView.findViewById(R.id.tvNumeroCuentaOrigen);
        tvNumeroCuentaDestino = (TextView) listItemView.findViewById(R.id.tvNumeroCuentaDestino);
    }

    public void render(Movimiento movement) {

        // 6. Set the object atributtes to TextView (Set toi TextView).
        tvIdMovement.setText(movement.getId());
        tvtipo.setText(movement.getTipo());
        tvFechaOperacion.setText((CharSequence) movement.getFechaOperacion());
        tvDescripcion.setText(movement.getDescripcion());
        tvImporte.setText((int) movement.getImporte());
        tvNumeroCuentaOrigen.setText(movement.getCuentaOrigen().getNumeroCuenta());
        tvNumeroCuentaDestino.setText(movement.getCuentaDestino().getNumeroCuenta());
    }

}
