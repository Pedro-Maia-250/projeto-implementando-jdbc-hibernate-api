package com.lunarvoid.entities;

import java.lang.StringBuilder;
import com.lunarvoid.enums.TipoFormas;

public class Quadrado extends Forma {
    private Double lado;

    public Quadrado(Double lado){
        super(TipoFormas.QUADRADO);
        setLado(lado);
    }

    private void setLado(Double lado){
        this.lado = lado;
    }

    public Double getLado(){
        return this.lado;
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
        sb.append(getTipo().toString());
        sb.append(" Lado: ");
        sb.append(this.lado);
        sb.append(" Area: ");
        sb.append(String.format("%.2f",area()));
        sb.append(" Perimetro: ");
        sb.append(String.format("%.2f",perimetro()));

        return sb.toString();
    }
}
