package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.practicas.pmdm.mybank.pojo.Cuenta;
import com.practicas.pmdm.mybank.R;

import java.util.List;

public class CuentasArrayAdapter extends ArrayAdapter<Cuenta> {


    public CuentasArrayAdapter(@NonNull Context context, int resource, @NonNull List<Cuenta> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            listItemView = inflater.inflate(R.layout.rows_cuentas, parent, false);
        }

        //Obteniendo instancias de los text views y del ImageView
        TextView banco = (TextView) listItemView.findViewById(R.id.tvBanco);
        TextView sucursal = (TextView) listItemView.findViewById(R.id.tvSucursal);
        TextView dc = (TextView) listItemView.findViewById(R.id.tvDC);
        TextView numeroCuenta = (TextView) listItemView.findViewById(R.id.tvNumeroCuenta);
        TextView saldoActual = (TextView) listItemView.findViewById(R.id.tvSaldoActual);

        //Obteniendo instancia de la Tarea en la posición actual
        Cuenta cuenta = (Cuenta) getItem(position);

        // TODO: No puc accedir als atributs de l'objecte.
        banco.setText(cuenta.getId());
        sucursal.setText(cuenta.getNumeroCuenta());
        dc.setText(cuenta.getBanco());
        numeroCuenta.setText(cuenta.getNumeroCuenta());
        saldoActual.setText(Float.toString(cuenta.getSaldoActual()));

        return listItemView;
    }

}
