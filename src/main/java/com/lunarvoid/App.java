//dao

package com.lunarvoid;

import com.lunarvoid.dao.CirculoDAO;
import com.lunarvoid.dao.DaoFactoryForma;
import com.lunarvoid.dao.QuadradoDAO;
import com.lunarvoid.dao.RetanguloDAO;
import com.lunarvoid.entities.Circulo;
import com.lunarvoid.entities.Quadrado;
import com.lunarvoid.entities.Retangulo;

public class App {
    public static void main(String[] args) {
            
        QuadradoDAO qdao = DaoFactoryForma.createQuadradoDAO();
        CirculoDAO cdao = DaoFactoryForma.createCirculoDAO();
        RetanguloDAO rdao = DaoFactoryForma.createRetanguloDAO();

        qdao.insert(new Quadrado(5.4));
        qdao.insert(new Quadrado(3.2));
        qdao.insert(new Quadrado(8.0));

        cdao.insert(new Circulo(2.4));
        cdao.insert(new Circulo(8.0));

        rdao.insert(new Retangulo(5.4,3.2));

        for (Quadrado q : qdao.findAll()) {
            System.out.println(q);
        }

        for (Circulo c : cdao.findAll()) {
            System.out.println(c);
        }

        for (Retangulo r : rdao.findAll()) {
            System.out.println(r);
        }

    }
}
