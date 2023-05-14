package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.practicas.pmdm.mybank.LogedActivity;
import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.ArrayList;

public class CuentaArrayAdapter extends ArrayAdapter<Cuenta> {

    /**
     * Constructor. This constructor will result in the underlying data collection being
     * immutable, so methods such as {@link #clear()} will throw an exception.
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public CuentaArrayAdapter(@NonNull Context context, int resource, @NonNull Cuenta[] objects) {
        super(context, resource, objects);
    }

    public CuentaArrayAdapter(LogedActivity context, ArrayList<Cuenta> listCuenta) {
        super(context, 0, listCuenta);
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
            listItemView = inflater.inflate(R.layout.list_row_cuenta, parent, false);
        }

        // Get TextView rows / atributtes
        TextView tvBanco = (TextView) listItemView.findViewById(R.id.tvBanco);
        TextView tvSucursal = (TextView) listItemView.findViewById(R.id.tvSucursal);
        TextView tvDc = (TextView) listItemView.findViewById(R.id.tvDc);
        TextView tvNumeroCuenta = (TextView) listItemView.findViewById(R.id.tvNumeroCuenta);
        TextView tvSaldo = (TextView) listItemView.findViewById(R.id.tvSaldo);
        // ImageView image = (ImageView) listItemView.findViewById(R.id.tvSaldo);

        //Obteniendo instancia de la Tarea en la posición actual
        Cuenta cuenta = (Cuenta) getItem(position);

        // Set the object atributtes to TextView.
        tvBanco.setText(cuenta.getBanco());
        tvSucursal.setText(cuenta.getSucursal());
        tvDc.setText(cuenta.getDc());
        tvNumeroCuenta.setText(cuenta.getNumeroCuenta());
        tvSaldo.setText(String.valueOf(cuenta.getSaldoActual()));

        return listItemView;
    }

}
