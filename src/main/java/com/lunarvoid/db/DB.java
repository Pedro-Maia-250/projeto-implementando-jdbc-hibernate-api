package com.lunarvoid.db;

    import java.sql.Connection;
    import com.lunarvoid.utilitarios.Config;

public class DB {
    private static final String URL = Config.get("db.url");
    private static final String USER = Config.get("db.user");
    private static final String PASSWORD = Config.get("db.password");
    private static Connection conn = null;

    static{

    }

    public static Connection getConnection(){
    }
}
