package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practicas.pmdm.mybank.adapter.AccountAdapter;
import com.practicas.pmdm.mybank.adapter.CuentaArrayAdapter;
import com.practicas.pmdm.mybank.adapter.OnItemClickListener;
import com.practicas.pmdm.mybank.dao.CuentaDAO;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class LogedActivity extends AppCompatActivity
        implements OnItemClickListener {

    CuentaDAO cuentaDAO = new CuentaDAO();
    AccountAdapter accountAdapter = null;
    RecyclerView rvList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged);

        Cliente cliente = (Cliente) getIntent().getSerializableExtra("user");

        TextView tvUser = (TextView) findViewById(R.id.etUser);
        tvUser.setText(cliente.getNombre() + " " + cliente.getApellidos());

        // 1. Get list from Dao (Dao List).
        List<Cuenta> listCuenta = cuentaDAO.getCuentas(cliente);

        // 2. Instance Adapter and put list into it (adapter(list)).
        initRecyclerView(listCuenta);

        // 3. Get Recycleriew component from the listview (findViewById - list).
        //lvList = (RecyclerView) findViewById(R.id.lvList);
        //lvList.setAdapter(accountAdapter);

        //cuentaArrayAdapter = new CuentaArrayAdapter(this, 0, listCuenta);

        // 4. Set Adapter(Rows) into list component (setAdapter).
        //lvMenu.setAdapter(cuentaArrayAdapter);
        // 5. Set event to onclick.
        /*
        ListView list = (ListView) findViewById(R.id.lvList);
        list.setAdapter(cuentaArrayAdapter);
        list.setClickable(true);
        list.setOnItemClickListener(this);
        */

        // 5. Call the view if it's different than the actual view (return View).
        //startActivity(pageReturned);
    }

    public void initRecyclerView(List<Cuenta> listcuenta) {
        // Adapter
        accountAdapter = new AccountAdapter(listcuenta, this, this);
        //accountAdapter.setOnItemClickListener(this);
        // RecyclerView
        rvList = (RecyclerView) findViewById(R.id.lvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(accountAdapter);
    }

    public void goHome(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MainActivity.class);
        startActivity(pageReturned);
    }

    public void goMovements(View view) {

        Intent pageReturned = new Intent(LogedActivity.this, MovementActivity.class);
        startActivity(pageReturned);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}