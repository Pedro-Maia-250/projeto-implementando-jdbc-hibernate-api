package com.lunarvoid.entities;

import com.lunarvoid.enums.TipoFormas;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "circulo")
public class Circulo extends Forma {
    
    @Column(nullable = false)
    private Double diametro;

    public Circulo(Double diametro){
        super(TipoFormas.CIRCULO);
        setDiametro(diametro);
    }

    protected Circulo(){}

    private void setDiametro(Double diametro){
        this.diametro = diametro;
    }

    public Double area(){
        Double raio = this.diametro / 2;
        return Math.PI * (raio * raio);
    }

    public Double perimetro(){
        return Math.PI * this.diametro;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo: ");
        sb.append(getTipo().toString());
        sb.append(" Diametro: ");
        sb.append(this.diametro);
        sb.append(" Area: ");
        sb.append(String.format("%.2f",area()));
        sb.append(" Perimetro: ");
        sb.append(String.format("%.2f",perimetro()));

        return sb.toString();
    }
    
}
