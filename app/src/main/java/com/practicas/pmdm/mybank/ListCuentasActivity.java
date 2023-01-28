package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.practicas.pmdm.mybank.adapter.CuentasArrayAdapter;
import com.practicas.pmdm.mybank.dao.ClienteDAO;
import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class ListCuentasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    CuentaDAO cuentaDAO = new CuentaDAO();
    CuentasArrayAdapter cuentaCuentasArrayAdapter = null;

    ListView lvCuentas;
    List<Cuenta> cuentasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cuentas);
    }

    private List<Cuenta> init(Cliente cliente) {
        // Get list for layout.
        lvCuentas = findViewById(R.id.lvListCuentas);
        // Get Data.
        cuentasList = cuentaDAO.getCuentas(cliente);
        // Init Adapter.
        cuentaCuentasArrayAdapter = new CuentasArrayAdapter(this, cuentasList.size(), cuentasList);
        // Set Adapter to List.
        lvCuentas.setAdapter(cuentaCuentasArrayAdapter);

        return cuentasList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Cuenta cuenta = (Cuenta) cuentaCuentasArrayAdapter.getItem(position);
        String msg = "Elegiste el plato:\n" + cuenta.getBanco() + " - " + cuenta.getNumeroCuenta() + "\n Su precio es: " + cuenta.getSaldoActual();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}