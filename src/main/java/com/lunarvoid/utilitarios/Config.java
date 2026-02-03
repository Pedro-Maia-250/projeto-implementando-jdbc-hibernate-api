package com.lunarvoid.utilitarios;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties properties = new Properties();

    static{
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("db.properties")) {
            
            if (input == null) {
                throw new RuntimeException(
                    "db.properties não encontrado no classpath"
                );
            }

            properties.load(input);

        } catch (Exception e) {
             throw new RuntimeException(
                "Erro ao carregar db.properties: " + e.getMessage()
            );
        }

    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
