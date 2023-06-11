package com.practicas.pmdm.mybank.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Cuenta;

public class AccountViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener listener;

    TextView tvBanco;
    TextView tvSucursal;
    TextView tvDc;
    TextView tvNumeroCuenta;
    TextView tvSaldo;

    // Constructor
    public AccountViewHolder(@NonNull View itemView) {
        super(itemView);

        // 4. Get TextView rows / atributtes (Cast to TextView).
        tvBanco = (TextView) itemView.findViewById(R.id.tvBanco);
        tvSucursal = (TextView) itemView.findViewById(R.id.tvSucursal);
        tvDc = (TextView) itemView.findViewById(R.id.tvDc);
        tvNumeroCuenta = (TextView) itemView.findViewById(R.id.tvNumeroCuenta);
        tvSaldo = (TextView) itemView.findViewById(R.id.tvSaldo);

        /* itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onItemClick(view, getAdapterPosition());
            }
        }); */
    }

    public void render(Cuenta account) {

        // 6. Set the object atributtes to TextView (Set toi TextView).
        tvBanco.setText(account.getBanco());
        tvSucursal.setText(account.getSucursal());
        tvDc.setText(account.getDc());
        tvNumeroCuenta.setText(account.getNumeroCuenta());
        tvSaldo.setText(String.valueOf(account.getSaldoActual()));
    }

}
