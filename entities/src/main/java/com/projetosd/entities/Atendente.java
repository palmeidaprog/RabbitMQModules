package com.projetosd.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Atendente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 7913610716949571054L;

    private String codigoCracha;

    public String getCodigoCracha() {
        return codigoCracha;
    }

    public void setCodigoCracha(String codigoCracha) {
        this.codigoCracha = codigoCracha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atendente)) return false;
        if (!super.equals(o)) return false;
        Atendente atendente = (Atendente) o;
        return Objects.equals(codigoCracha, atendente.codigoCracha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigoCracha);
    }
}
