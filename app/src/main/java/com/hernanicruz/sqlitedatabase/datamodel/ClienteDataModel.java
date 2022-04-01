package com.hernanicruz.sqlitedatabase.datamodel;

public class ClienteDataModel {

    //1 - Criar o nome da tabela
    public static final String TABELA = "cliente";

    //2- Atributos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    //3- Escrever a query de criação do bando de dados

    public static String queryCriarTabela = "";

    //4- Criar o método que vai criar a tabela
    public static String criarTabela(){
        //concatenção de string

        queryCriarTabela += "CREATE TABLE " + TABELA+"(";
        queryCriarTabela += ID+ " integer primary key autoincrement, ";
        queryCriarTabela += NOME+ " text, ";
        queryCriarTabela += EMAIL+ " text";
        queryCriarTabela += ")";
        return queryCriarTabela;
    }


}