package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.practicas.pmdm.mybank.adapter.AccountAdapter;
import com.practicas.pmdm.mybank.adapter.MovementAdapter;
import com.practicas.pmdm.mybank.adapter.MovementArrayAdapter;
import com.practicas.pmdm.mybank.adapter.OnItemClickListener;
import com.practicas.pmdm.mybank.dao.MovimientoDAO;
import com.practicas.pmdm.mybank.pojo.Cuenta;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class MovementActivity extends AppCompatActivity implements OnItemClickListener {

    MovimientoDAO movimientoDAO = new MovimientoDAO();
    MovementArrayAdapter movementArrayAdapter = null;
    MovementAdapter adapter;

    ListView lvMenu = null;
    RecyclerView rvList = null;

    List<Movimiento> listMovement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);

        Cuenta account = (Cuenta) getIntent().getSerializableExtra("account");

        // 1. Get list from Dao (Dao List).
        listMovement = movimientoDAO.getMovimientos(account);
        initRecyclerView(listMovement);


/*        // 2. Instance Adapter and put list into it (adapter(list)).
        movementArrayAdapter = new MovementArrayAdapter(this, 0, listMovement);
        // 3. Get list component from the listview (findViewById - list).
        lvMenu = findViewById(R.id.rvList2);
        // 4. Set Adapter(Rows) into list component (setAdapter).
        lvMenu.setAdapter(movementArrayAdapter);*/
    }

    public void initRecyclerView(List<Movimiento> listMovement) {
        // Adapter
        adapter = new MovementAdapter(listMovement, this, this);
        //accountAdapter.setOnItemClickListener(this);
        // RecyclerView
        rvList = (RecyclerView) findViewById(R.id.lvList2);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
/*        Movimiento movementClicked = listMovement.get(position);

        Intent intent = new Intent(MovementActivity.this, MovementActivity.class);
        intent.putExtra("account", movementClicked);
        startActivity(intent);*/
    }

}