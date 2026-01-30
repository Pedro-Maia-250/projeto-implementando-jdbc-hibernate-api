package com.lunarvoid.dao;

import java.util.List;

public interface FormaDAO<T> {
    public void insert(T forma);
    public List<T> findAll();
}
