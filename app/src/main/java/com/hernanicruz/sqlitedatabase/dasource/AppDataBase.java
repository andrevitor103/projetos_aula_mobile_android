package com.hernanicruz.sqlitedatabase.dasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hernanicruz.sqlitedatabase.api.AppUtil;
import com.hernanicruz.sqlitedatabase.datamodel.ClienteDataModel;
import com.hernanicruz.sqlitedatabase.model.Cliente;

import java.util.ArrayList;
import java.util.List;

// extends SQLiteOpenHelper
public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "db.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando banco de dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public boolean insert(String tabela, ContentValues dados)
    {
        db = getWritableDatabase();
        boolean retorno = false;

        try
        {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e)
        {
            Log.d(AppUtil.TAG, "Erro ao inserir dados: " + e.getMessage());
        }
        return retorno;
    }

    public boolean deleteById(String tabela, int id)
    {
        db = getWritableDatabase();
        boolean retorno = false;

        retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados)
    {
        db = getWritableDatabase();
        boolean retorno = false;
        retorno = db.update(tabela,
                dados,
                "id = ?",
                new String[]{String.valueOf(dados.get("id"))}) > 0;
        return retorno;
    }

    @SuppressLint("Range")
    public List<Cliente> getAllClientes(String tabela)
    {
        Cliente obj;
        db = getReadableDatabase();
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + tabela;
        Cursor cursor;
        cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst())
        {
            do {
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                clientes.add(obj);
            } while(cursor.moveToNext());
        }
        return clientes;
    }
}
