package com.lunarvoid.entities;

import java.lang.StringBuilder;

public class Quadrado extends Forma {
    private Double lado;

    public Quadrado(String nome, Double lado){
        super(nome);
        this.lado = lado;
    }

    public Double area(){
        return (lado * lado);
    }

    public Double perimetro(){
        return (lado * 4);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: ");
        sb.append("Nome: " + getNome());
        sb.append("Lado: ");
        sb.append("Area: " + area());
        sb.append("Perimetro: " + perimetro());

        return sb.toString();
    }
}
