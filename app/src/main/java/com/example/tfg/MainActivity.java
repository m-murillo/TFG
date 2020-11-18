package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    EditText nombrePrenda, tipoPrenda;
    Button bEnviar;
    Connection conexion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombrePrenda = (EditText)findViewById(R.id.tNombrePrenda);
        tipoPrenda = (EditText)findViewById(R.id.tTipoPrenda);
        bEnviar = (Button)findViewById(R.id.bEnviar);

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarPrenda();
            }
        });
    }

/*    public Connection conexion(){
        try{
            //Verificar el registro de acceso
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //Conectar con SQLserver
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String url = "jdbc:sqlserver://LEFTO;DatabaseName=tfg";
            String name = "admin";
            String pass = "admin1";
            conexion = DriverManager.getConnection(url, name, pass);
            Toast.makeText(getApplicationContext(), "CONECTADO AL SERVER", Toast.LENGTH_SHORT).show();
        } catch (Exception e){ //Mensaje de error
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }*/

    public void agregarPrenda(){
        try{
            //Regla que añade lo que pongamos
            //PreparedStatement pst = conexion().prepareStatement("insert into prenda values (?,?)");
            //pst.setInt(1, Integer.parseInt(nombrePrenda.getText().toString()));
            //pst.setString(2, tipoPrenda.getText().toString());
            //pst.executeUpdate();

            //Verificar el registro de acceso
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //No se si sirve:
            //android:usesCleartextTraffic="true"
            //tools:targetApi="m"
            //En el manifest

            //Conectar con SQLserver
            String url = "jdbc:sqlserver://LEFTO\\trabajo:1433;DatabaseName=tfg"; //14.0.2027.2
            String name = "sa";
            String pass = "secret";
            conexion = DriverManager.getConnection(url, name, pass);

            String sql = "INSERT INTO prenda (id, tipo)"
                    + "VALUES (" + Integer.parseInt(nombrePrenda.getText().toString()) + ", " + tipoPrenda.getText().toString() + ")";

            Statement s1 = conexion.createStatement();
            s1.executeUpdate(sql);

            //Mensaje de que se ha agregado
            Toast.makeText(getApplicationContext(), "REGISTRADO SATISFACTORIAMENTE", Toast.LENGTH_SHORT).show();

            conexion.close();
        } catch (SQLException e){ //Mensaje de error
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}