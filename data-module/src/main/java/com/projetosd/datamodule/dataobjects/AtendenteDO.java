package com.projetosd.datamodule.dataobjects;

import com.projetosd.entities.Atendente;
import com.projetosd.entities.Pessoa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class AtendenteDO extends PessoaDO {

    @Column(name = "codigo_cracha")
    private String codigoCracha;

    @OneToMany(
        mappedBy = "atendente",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<AgendamentoDO> agendamentos;

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
}
