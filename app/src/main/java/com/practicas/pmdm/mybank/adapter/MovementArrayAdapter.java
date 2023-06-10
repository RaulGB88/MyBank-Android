package com.practicas.pmdm.mybank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.practicas.pmdm.mybank.LogedActivity;
import com.practicas.pmdm.mybank.R;
import com.practicas.pmdm.mybank.pojo.Cuenta;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class MovementArrayAdapter extends ArrayAdapter<Movimiento> {

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public MovementArrayAdapter(@NonNull Context context, int resource, @NonNull List<Movimiento> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Get the instance from inflater (LayoutInflater).
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Save the reference from View the row (View).
        View listItemView = convertView;

        // 3. Search, check (if exist) and get the view-rows in the project (LayaoutInflater.inflate)
        if (null == convertView) {
            listItemView = inflater.inflate(R.layout.list_row_cuenta, parent, false);
        }

        // 4. Get TextView rows / atributtes (Cast to TextView).
        TextView tvIdMovement = (TextView) listItemView.findViewById(R.id.tvIdMovement);
        TextView tvtipo = (TextView) listItemView.findViewById(R.id.tvTipo);
        TextView tvFechaOperacion = (TextView) listItemView.findViewById(R.id.tvFechaOperacion);
        TextView tvDescripcion = (TextView) listItemView.findViewById(R.id.tvDescripcion);
        TextView tvImporte = (TextView) listItemView.findViewById(R.id.tvImporte);
        TextView tvNumeroCuentaOrigen = (TextView) listItemView.findViewById(R.id.tvNumeroCuentaOrigen);
        TextView tvNumeroCuentaDestino = (TextView) listItemView.findViewById(R.id.tvNumeroCuentaDestino);
        // ImageView image = (ImageView) listItemView.findViewById(R.id.tvSaldo);

        // 5. Get the instance form item (object) at the actual position (getItem).
        Movimiento movimiento = (Movimiento) getItem(position);

        // 6. Set the object atributtes to TextView (Set toi TextView).
        tvIdMovement.setText(movimiento.getId());
        tvtipo.setText(movimiento.getTipo());
        tvFechaOperacion.setText((CharSequence) movimiento.getFechaOperacion());
        tvDescripcion.setText( movimiento.getDescripcion());
        tvImporte.setText((int) movimiento.getImporte());
        tvNumeroCuentaOrigen.setText(movimiento.getCuentaOrigen().getNumeroCuenta());
        tvNumeroCuentaDestino.setText(movimiento.getCuentaDestino().getNumeroCuenta());

        // 7. Return the listview (return Adapter-Rows).
        return listItemView;
    }

}
