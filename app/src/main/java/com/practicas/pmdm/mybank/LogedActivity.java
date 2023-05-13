package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LogedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged);

        Cliente cliente = (Cliente) getIntent().getSerializableExtra("user");

        TextView tvUser = (TextView) findViewById(R.id.etUser);
        tvUser.setText(cliente.getNombre() + " " + cliente.getApellidos());

        CuentaDAO cuentaDAO = new CuentaDAO();
        ArrayList<Cuenta> listCuenta = cuentaDAO.getCuentas(cliente);
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