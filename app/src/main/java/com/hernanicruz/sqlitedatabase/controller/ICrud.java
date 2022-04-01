package com.hernanicruz.sqlitedatabase.controller;

import java.util.List;

public interface ICrud<T> {

    public boolean incluir(T obj);
    public boolean alterar(T obj);
    public boolean deletar(String tabela, int id);
    public List<T> listar();

}
