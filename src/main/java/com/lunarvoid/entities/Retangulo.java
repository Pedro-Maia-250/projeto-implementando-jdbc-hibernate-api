package com.lunarvoid.entities;

import com.lunarvoid.enums.TipoFormas;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "retangulo")
public class Retangulo extends Forma {
    @Column(nullable = false)
    private Double lado1;
    @Column(nullable = false)
    private Double lado2;

    protected Retangulo(){}

    public Retangulo(Double lado1, Double lado2){
        super(TipoFormas.RETANGULO);
        setLados(lado1, lado2);
    }

    private void setLados(Double lado1, Double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Double area(){
        return (this.lado1 * this.lado2);
    }

    public Double perimetro(){
        return ((this.lado1 * 2) + (this.lado2 * 2));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo: ");
        sb.append(getTipo().toString());
        sb.append(" Lado1: ");
        sb.append(this.lado1);
        sb.append(" Lado2: ");
        sb.append(this.lado2);
        sb.append(" Area: ");
        sb.append(String.format("%.2f",area()));
        sb.append(" Perimetro: ");
        sb.append(String.format("%.2f",perimetro()));

        return sb.toString();
    }

}
