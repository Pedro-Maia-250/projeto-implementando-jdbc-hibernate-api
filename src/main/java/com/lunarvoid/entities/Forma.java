package com.lunarvoid.entities;

import com.lunarvoid.interfaces.FormaInterface;
import java.io.Serializable;
import com.lunarvoid.enums.TipoFormas;

public abstract class Forma implements FormaInterface, Serializable {

    private static final long serialVersionUID = 1L;

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
