package com.lunarvoid.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lunarvoid.utilitarios.Config;

public final class DB {
    private static final String URL = Config.get("db.url");
    private static final String USER = Config.get("db.user");
    private static final String PASSWORD = Config.get("db.password");
    private static Connection conn = null;

    public static Connection getConnection(){
        try{

            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }

            return conn;
            
        }catch(SQLException s){
            throw new RuntimeException("Falha ao acessar banco de dados" + s.getMessage());
        }
    }

    private DB(){}
}
