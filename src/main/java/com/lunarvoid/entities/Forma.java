package com.lunarvoid.entities;

import com.lunarvoid.interfaces.FormaInterface;
import com.lunarvoid.enums.TipoFormas;


public abstract class Forma implements FormaInterface {
    private TipoFormas tipo;

    public Forma(TipoFormas tipo){
        setTipo(tipo);
    }

    public TipoFormas getTipo(){
        return this.tipo;
    }

    private void setTipo(TipoFormas tipo){
        this.tipo = tipo;
    }
}
