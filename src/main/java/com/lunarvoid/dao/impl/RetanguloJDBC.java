package com.lunarvoid.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lunarvoid.dao.RetanguloDAO;
import com.lunarvoid.entities.Retangulo;

public class RetanguloJDBC implements RetanguloDAO {

    private Connection conn = null;

    public RetanguloJDBC(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Retangulo retangulo){
        try(PreparedStatement st = conn.prepareStatement("insert into retangulo(lado1,lado2) values (?,?)")){

            st.setDouble(1, retangulo.getLado1());
            st.setDouble(2, retangulo.getLado2());
            st.executeUpdate();

        }catch (SQLException s) {
            throw new RuntimeException("Erro ao inserir retangulo" + s.getMessage());
        }
    }

    public List<Retangulo> findAll(){
        List<Retangulo> retangulos = new ArrayList<>();

        try(PreparedStatement st = conn.prepareStatement("select * from retangulo");
            ResultSet rs = st.executeQuery()){
            
            while(rs.next()){

                Retangulo retangulo = new Retangulo(rs.getDouble("lado1"),rs.getDouble("lado2"));
                retangulos.add(retangulo);

            }

            return retangulos;
        }catch(SQLException s){
            throw new RuntimeException("Erro ao buscar retangulos" + s.getMessage());
        }
    }
}
