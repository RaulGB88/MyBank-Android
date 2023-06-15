package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.practicas.pmdm.mybank.adapter.MovementArrayAdapter;
import com.practicas.pmdm.mybank.dao.MovimientoDAO;
import com.practicas.pmdm.mybank.pojo.Cuenta;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.ArrayList;

public class MovementActivity extends AppCompatActivity {

    MovimientoDAO movimientoDAO = new MovimientoDAO();
    MovementArrayAdapter movementArrayAdapter = null;

    ListView lvMenu = null;

    ArrayList<Movimiento> listMovement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);

        Cuenta account = (Cuenta) getIntent().getSerializableExtra("account");

        // 1. Get list from Dao (Dao List).
        listMovement = movimientoDAO.getMovimientos(account);
        // 2. Instance Adapter and put list into it (adapter(list)).
        movementArrayAdapter = new MovementArrayAdapter(this, 0, listMovement);
        // 3. Get list component from the listview (findViewById - list).
        lvMenu = findViewById(R.id.lvList2);
        // 4. Set Adapter(Rows) into list component (setAdapter).
        lvMenu.setAdapter(movementArrayAdapter);
    }

}