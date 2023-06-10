package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.practicas.pmdm.mybank.adapter.CuentaArrayAdapter;
import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.ArrayList;

public class LogedActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    CuentaDAO cuentaDAO = new CuentaDAO();
    CuentaArrayAdapter cuentaArrayAdapter = null;
    ListView lvMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged);

        Cliente cliente = (Cliente) getIntent().getSerializableExtra("user");

        TextView tvUser = (TextView) findViewById(R.id.etUser);
        tvUser.setText(cliente.getNombre() + " " + cliente.getApellidos());

        // 1. Get list from Dao (Dao List).
        ArrayList<Cuenta> listCuenta = cuentaDAO.getCuentas(cliente);
        // 2. Instance Adapter and put list into it (adapter(list)).
        cuentaArrayAdapter = new CuentaArrayAdapter(this, 0, listCuenta);
        // 3. Get list component from the listview (findViewById - list).
        //lvMenu = findViewById(R.id.lvList);
        // 4. Set Adapter(Rows) into list component (setAdapter).
        //lvMenu.setAdapter(cuentaArrayAdapter);
        // 5. Set event to onclick.
        ListView list = (ListView) findViewById(R.id.lvList);
        list.setAdapter(cuentaArrayAdapter);
        list.setClickable(true);
        list.setOnItemClickListener(this);

        // 5. Call the view if it's different than the actual view (return View).
        //startActivity(pageReturned);
    }

    public void goHome(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MainActivity.class);
        startActivity(pageReturned);
    }

    public void goMovements(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MovementActivity.class);
        startActivity(pageReturned);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cuenta cuentaClicked = cuentaArrayAdapter.getItem(position);
        Intent intent = new Intent(LogedActivity.this, MovementActivity.class);
        intent.putExtra("cuenta", cuentaClicked);
        /*
        intent.putExtra("id", cuentaClicked.getId());
        intent.putExtra("banco", cuentaClicked.getBanco());
        intent.putExtra("sucursal", cuentaClicked.getSucursal());
        intent.putExtra("dc", cuentaClicked.getDc());
        intent.putExtra("numeroCuenta", cuentaClicked.getNumeroCuenta());
        intent.putExtra("saldoActual", cuentaClicked.getSaldoActual());
        */
        startActivity(intent);
    }
}