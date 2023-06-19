package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.practicas.pmdm.mybank.dao.ClienteDAO;
import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextView txtDNI;
    TextView txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @SuppressLint("ResourceAsColor")
    public void goWellcome(View view) {

        txtDNI = (TextView) findViewById(R.id.etDNI);
        String dni = (String) txtDNI.getText().toString();

        txtPass = (TextView) findViewById(R.id.etPass);
        String pass = (String) txtPass.getText().toString();

        Cliente cliente = new Cliente();
        cliente.setNif(dni);
        cliente.setClaveSeguridad(pass);

        Intent pageReturned = new Intent(LoginActivity.this, MainActivity.class);

        // Get all clients.
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> listCliente = clienteDAO.getAll();

        boolean clientChecked = false;

        // Check Client.
        for(Cliente c : listCliente)  {
            if (cliente.getNif().equalsIgnoreCase(c.getNif()) && cliente.getClaveSeguridad().equalsIgnoreCase(c.getClaveSeguridad())) {
                pageReturned = new Intent(LoginActivity.this, LogedActivity.class);
                clientChecked = true;

                // Pasamos el usuario logeqado al siguiente Activity (LogedActivity)
                Intent intent = new Intent(getApplicationContext(), LogedActivity.class);
                intent.putExtra("user", c);
                startActivity(intent);

            }
        }

        if(!clientChecked) {
            TextView txtLoginWrong = (TextView) findViewById(R.id.loginIncorrecto);
            txtLoginWrong.setText(R.string.loginIncorrecto);
            txtLoginWrong.setTextColor(R.color.red);
        }
    }

}