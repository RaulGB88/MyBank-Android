package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.practicas.pmdm.mybank.adapter.CuentaArrayAdapter;
import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LogedActivity extends AppCompatActivity {

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
        cuentaArrayAdapter = new CuentaArrayAdapter(this, listCuenta);
        // 3. Get list component from the listview (findViewById - list).
        lvMenu = findViewById(R.id.lvList);
        // 4. Set Adapter(Rows) into list component (setAdapter).
        lvMenu.setAdapter(cuentaArrayAdapter);

        // 5. Call the view if it's different than the actual view (return View).
        //startActivity(pageReturned);
    }

    public void goHome(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MainActivity.class);
        startActivity(pageReturned);
    }

    /*private void init() {
        // Get list for layout.
        lvMenu = findViewById(R.id.lvList);
        // Get Data.
        listInstalacion = instalacionesDao.getPlateList();
        // Init Adapter.
        adapter = new InstalacionArrayAdapter<>(this, listInstalacion);
        // Set Adapter to List.
        lvMenu.setAdapter(adapter);
    }


    private void recieveData() {
        Bundle extras = getIntent().getExtras();
        String dni = (String) extras.get("dni");

        txtUserDNI = (TextView) findViewById(R.id.txtUserDNI);
        txtUserDNI.setText(dni);
    }*/

}