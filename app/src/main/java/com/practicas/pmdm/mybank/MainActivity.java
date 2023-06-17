package com.practicas.pmdm.mybank;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.practicas.pmdm.mybank.bd.MiBancoOperacional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Clean
        TextView txtdatos = (TextView) findViewById(R.id.textView1);
        txtdatos.append("");

        // Charge BD.
        MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);
    }

    public void goLogin(View view) {

        //Button page = (Button) view.findViewById(R.id.btnLogin);

        Intent pageReturned = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(pageReturned);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_login:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
/*                i.putExtra(Constantes.C_MODO, Constantes.C_CREAR);
                startActivityForResult(i, Constantes.C_CREAR);*/
                return true;
            case R.id.menu_registrtion:
                intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
/*                i.putExtra(Constantes.C_MODO, Constantes.C_CREAR);
                startActivityForResult(i, Constantes.C_CREAR);*/
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}