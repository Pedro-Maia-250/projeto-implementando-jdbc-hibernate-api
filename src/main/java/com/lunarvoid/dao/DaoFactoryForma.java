package com.lunarvoid.dao;

import com.lunarvoid.dao.impl.*;
import com.lunarvoid.db.DB;

public final class DaoFactoryForma {
    public static QuadradoDAO createQuadradoDAO(){
        return new QuadradoJDBC(DB.getConnection());
    }

    public static CirculoDAO createCirculoDAO(){
        return new CirculoJDBC(DB.getConnection());
    }

    public static RetanguloDAO createRetanguloDAO(){
        return new RetanguloJDBC(DB.getConnection());
    }
}
