package com.hernanicruz.sqlitedatabase.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hernanicruz.sqlitedatabase.R;
import com.hernanicruz.sqlitedatabase.controller.ClienteController;
import com.hernanicruz.sqlitedatabase.model.Cliente;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 50; i++)
        {
            clienteController = new ClienteController(getApplicationContext());
            obj = new Cliente();
            obj.setNome("nome cliente");
            obj.setEmail("nomeCliente" + i +"@mail.com");

            clienteController.incluir(obj);
        }
        if(clienteController.deletar("cliente", 10)) {
            Toast.makeText(this, "ID deletado" + 6, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "ID não encontrado", Toast.LENGTH_LONG).show();
        }
        obj.setId(4);
        obj.setNome("Andre Vitor");
        obj.setEmail("email@mail.com");

        clienteController.alterar(obj);

        for(Cliente obj: clienteController.listar() ) {
            Log.d("TAGs", "Lista de Clientes" + obj.getId() + " " + obj.getNome());
        }
    }
}
