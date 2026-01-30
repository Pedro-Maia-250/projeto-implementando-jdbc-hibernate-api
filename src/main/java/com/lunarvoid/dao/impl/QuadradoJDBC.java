package com.lunarvoid.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lunarvoid.dao.QuadradoDAO;
import com.lunarvoid.entities.Quadrado;

public class QuadradoJDBC implements QuadradoDAO {

    private Connection conn = null;

    public QuadradoJDBC(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Quadrado quadrado){

        try(PreparedStatement st = conn.prepareStatement("insert into quadrado(lado) values (?)")){

            st.setDouble(1, quadrado.getLado());
            st.executeUpdate();

        }catch (SQLException s) {
            throw new RuntimeException("Erro ao inserir quadrado" + s.getMessage());
        }

    }

    public List<Quadrado> findAll(){
        List<Quadrado> quadrados = new ArrayList<>();

        try(PreparedStatement st = conn.prepareStatement("select * from quadrado");
            ResultSet rs = st.executeQuery()){
            
            while(rs.next()){
                
                Quadrado quadrado = new Quadrado(rs.getDouble("lado"));
                quadrados.add(quadrado);
                
            }

            return quadrados;
        }catch(SQLException s){
            throw new RuntimeException("Erro ao buscar quadrados" + s.getMessage());
        }
    }
}