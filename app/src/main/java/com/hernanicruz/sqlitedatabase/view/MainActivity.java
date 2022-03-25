package com.hernanicruz.sqlitedatabase.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hernanicruz.sqlitedatabase.R;
import com.hernanicruz.sqlitedatabase.controller.ClienteController;
import com.hernanicruz.sqlitedatabase.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());
        obj = new Cliente();
        obj.setNome("nome cliente");
        obj.setEmail("nomeCliente@mail.com");

        clienteController.incluir(obj);
    }
}