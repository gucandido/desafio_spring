package com.desafio.desafiospring.repositories;

import java.util.List;

public interface Repo<T> {

    public <T> List<T> findAll();
    public <T> T findById(long id);
    public <T> T save(Object obj);
    public void delete(long id);

}
