package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged);
    }

    public void goHome(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MainActivity.class);
        startActivity(pageReturned);
    }
/*
    private void init() {
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
    }
     */
}