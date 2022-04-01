package com.hernanicruz.sqlitedatabase.controller;


import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.hernanicruz.sqlitedatabase.api.AppUtil;
import com.hernanicruz.sqlitedatabase.dasource.AppDataBase;
import com.hernanicruz.sqlitedatabase.datamodel.ClienteDataModel;
import com.hernanicruz.sqlitedatabase.model.Cliente;

import java.util.List;

// extends AppDataBase implements ICrud<Cliente>
public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadosDoObj;

    public ClienteController(Context context) {
        super(context);
        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadosDoObj = new ContentValues();
        //id, nome e email
        dadosDoObj.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());

        return insert(ClienteDataModel.TABELA, dadosDoObj);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadosDoObj = new ContentValues();
        dadosDoObj.put(ClienteDataModel.ID, obj.getId());
        dadosDoObj.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());

        return update(ClienteDataModel.TABELA, dadosDoObj);
    }

    @Override
    public boolean deletar(String tabela, int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {
        return getAllClientes(ClienteDataModel.TABELA);
    }
}
