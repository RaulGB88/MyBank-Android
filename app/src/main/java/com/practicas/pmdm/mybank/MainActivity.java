package com.practicas.pmdm.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.practicas.pmdm.mybank.bd.MiBD;
import com.practicas.pmdm.mybank.bd.MiBancoOperacional;
import com.practicas.pmdm.mybank.pojo.Cliente;
import com.practicas.pmdm.mybank.pojo.Cuenta;
import com.practicas.pmdm.mybank.pojo.Movimiento;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiBancoOperacional mbo = MiBancoOperacional.getInstance(this);

        TextView txtdatos=(TextView)findViewById(R.id.textView1);

        // Introducimos los datos como si fuera la pantalla inicial
        Log.e(this.getComponentName().getClassName(), "Creando el cliente a");
        Cliente a = new Cliente();
        a.setNif("11111111A");
        a.setClaveSeguridad("1234");

        // logueamos al cliente
        a = mbo.login(a);

        txtdatos.append("Datos del cliente logueado\n");
        txtdatos.append("-----------------------------------------\n");
        txtdatos.append(a.toString()+"\n");
        txtdatos.append("\n");

        // Cambiamos la password
        txtdatos.append("Cambiamos la password del cliente\n");
        txtdatos.append("-----------------------------------------\n");
        txtdatos.append("\n");
        a.setClaveSeguridad("12345");
        int p = mbo.changePassword(a);
        txtdatos.append("Hemos obtenido tras cambiar un " + String.valueOf(p));
        txtdatos.append("\n");
        txtdatos.append("Password cambiada a 12345.\n");
        txtdatos.append("\n");

        // Creamos un nuevo cliente y intentamos loguearnos con la clave anterior
        txtdatos.append("Intentamos loguear el cliente con la password inicial, que era 1234\n");
        txtdatos.append("---------------------------------------------------------------------------------\n");
        txtdatos.append("\n");
        Cliente b = new Cliente();
        b.setNif("11111111A");
        b.setClaveSeguridad("1234");

        b = mbo.login(b);

        if(b==null){
            txtdatos.append("No ha podido loguearse con 1234 como password.\n");
            txtdatos.append("\n");
        }else{
            txtdatos.append("Error: Ha podidod loguearse con la password anterior. Es necesario revisar el código.\n");
            txtdatos.append("\n");
        }

        // Volvemos a dejar la password como estaba y nos logueamos de nuevo
        txtdatos.append("Volvemos a dejar la password como estaba y nos logueamos de nuevo\n");
        txtdatos.append("---------------------------------------------------------------------------------\n");
        txtdatos.append("\n");
        Cliente c = new Cliente();
        c.setNif("11111111A");
        c.setClaveSeguridad("12345");

        c = mbo.login(c);
        c.setClaveSeguridad("1234");
        mbo.changePassword(c);
        txtdatos.append("Password cambiada a 1234. Nos logueamos de nuevo.\n");
        txtdatos.append("\n");

        Cliente d = new Cliente();
        d.setNif("11111111A");
        d.setClaveSeguridad("1234");

        // logueamos al cliente
        d = mbo.login(d);

        txtdatos.append("Datos del cliente logueado\n");
        txtdatos.append("-----------------------------------------\n");
        txtdatos.append(d.toString() + "\n");
        txtdatos.append("\n");

        txtdatos.append("Obtenemos la lista de cuentas del cliente logueado.\n");
        txtdatos.append("------------------------------------------------------------------------------\n");
        ArrayList<Cuenta> listaCuentas = mbo.getCuentas(a);

        for(int i=0;i<listaCuentas.size();i++){
            txtdatos.append("\n" + listaCuentas.get(i).toString() + "\n");
        }
        txtdatos.append("\n");

        txtdatos.append("Obtenemos la lista de movimientos de la primera cuenta del cliente logueado.\n");
        txtdatos.append("----------------------------------------------------------------------------------------------------\n");
        ArrayList<Movimiento> listaMovimientos = mbo.getMovimientos(listaCuentas.get(0));

        for(int i=0;i<listaMovimientos.size();i++){
            txtdatos.append("\n" + listaMovimientos.get(i).toString() + "\n");
        }
        txtdatos.append("Probamos una cuenta que no exista.\n");
        txtdatos.append("----------------------------------------------------------------------------------------------------\n");

        Cuenta cuenta  =listaCuentas.get(0);
        cuenta.setId(11111);
        cuenta.setBanco(null);
        cuenta = (Cuenta) MiBD.getInstance(this).getCuentaDAO().search((Cuenta)cuenta);
    }
}