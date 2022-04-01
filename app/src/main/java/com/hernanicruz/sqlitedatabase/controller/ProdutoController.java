package com.hernanicruz.sqlitedatabase.controller;

import java.util.List;

// Falta extender AppDataBase
public class ProdutoController implements ICrud{

    @Override
    public boolean incluir(Object obj) {
        return false;
    }

    @Override
    public boolean alterar(Object obj) {
        return false;
    }

    @Override
    public boolean deletar(String tabela, int id) {
        return false;
    }

    @Override
    public List listar() {
        return null;
    }
}
