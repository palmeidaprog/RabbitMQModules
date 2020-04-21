package com.projetosd.datamodule.dataobjects;

import com.projetosd.entities.Atendente;
import com.projetosd.entities.Pessoa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "atendente")
public class AtendenteDO extends PessoaDO {

    @Column(name = "codigo_cracha")
    private String codigoCracha;

    public AtendenteDO(Atendente atendente) {
        super(atendente);
        this.codigoCracha = atendente.getCodigoCracha();
    }

    public AtendenteDO() {
    }

    public String getCodigoCracha() {
        return codigoCracha;
    }

    public void setCodigoCracha(String codigoCracha) {
        this.codigoCracha = codigoCracha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtendenteDO)) return false;
        AtendenteDO that = (AtendenteDO) o;
        return Objects.equals(codigoCracha, that.codigoCracha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCracha);
    }
}
