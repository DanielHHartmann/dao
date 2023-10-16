package model.dao;

import java.util.List;

import model.entities.Teste;

public interface TesteDao {

    void insert(Teste obj);
    void update(Teste obj);
    void deleteById(Integer id);
    Teste findById(Integer id);
    List<Teste> findAll();
}

