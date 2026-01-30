package com.lunarvoid.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lunarvoid.dao.CirculoDAO;
import com.lunarvoid.entities.Circulo;

public class CirculoJDBC implements CirculoDAO {

    private Connection conn = null;

    public CirculoJDBC(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Circulo circulo){

        try(PreparedStatement st = conn.prepareStatement("insert into circulo(diametro) values (?)")){

            st.setDouble(1, circulo.getDiametro());
            st.executeUpdate();

        }catch (SQLException s) {
            throw new RuntimeException("Erro ao inserir circulo" + s.getMessage());
        }

    }

    public List<Circulo> findAll(){

        List<Circulo> circulos = new ArrayList<>();

        try(PreparedStatement st = conn.prepareStatement("select * from circulo");
            ResultSet rs = st.executeQuery()){
            
            while(rs.next()){
                
                Circulo circulo = new Circulo(rs.getDouble("diametro"));
                circulos.add(circulo);
                
            }

            return circulos;
        }catch(SQLException s){
            throw new RuntimeException("Erro ao buscar circulos" + s.getMessage());
        }
    }
}
