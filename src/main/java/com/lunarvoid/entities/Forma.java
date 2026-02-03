package com.lunarvoid.entities;

import com.lunarvoid.interfaces.FormaInterface;
import com.lunarvoid.enums.TipoFormas;
import javax.persistence.*;

@MappedSuperclass
public abstract class Forma implements FormaInterface {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoFormas tipo;

    protected Forma() {}

    public Forma(TipoFormas tipo){
        setTipo(tipo);
    }

    public Integer getId() {
        return id;
    }

    public TipoFormas getTipo(){
        return this.tipo;
    }

    private void setTipo(TipoFormas tipo){
        this.tipo = tipo;
    }
}
