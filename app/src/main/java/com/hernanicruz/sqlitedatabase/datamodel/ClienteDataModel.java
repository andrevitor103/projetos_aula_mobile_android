package com.hernanicruz.sqlitedatabase.datamodel;

import java.lang.reflect.Array;

public class ClienteDataModel {
    //1 - nome tabela
    public static final String TABELA =  "cliente";

    //2- Atributos

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    //3- Consulta banco

    private static String queryCriarTabela = "";

    //4 - Método criar a tabela
    public static String criarTabela()
    {
        //concatenar string

        queryCriarTabela = criarCampos();
        return null;
    }

    private static String criarCampos()
    {
        String campos = "";
        campos.concat("CREATE TABLE  " + TABELA + "(");
        campos.concat(ID + " integer primary key autoincrement");
        campos.concat(NOME + " text, ");
        campos.concat(EMAIL + " text");
        campos.concat(")");
        return campos;
    }

}
