package com.hernanicruz.sqlitedatabase.dasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.hernanicruz.sqlitedatabase.api.AppUtil;
import com.hernanicruz.sqlitedatabase.datamodel.ClienteDataModel;

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

}

