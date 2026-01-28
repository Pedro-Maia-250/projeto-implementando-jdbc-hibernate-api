package com.lunarvoid.entities;

import com.lunarvoid.interfaces.FormaInterface;

abstract class Forma implements FormaInterface {
    private String nome;

    public Forma(String nome){
        setName(nome);
    }

    public String getNome(){
        return this.nome;
    }

    private void setName(String nome){
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("nome da forma não pode ser vazio");
        }
        this.nome = nome.trim().toUpperCase();
    }
}
