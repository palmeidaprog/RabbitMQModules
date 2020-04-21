package com.projetosd.datamodule.dataobjects;


import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "paciente")
public class PacienteDO extends PessoaDO {

    @Column(name = "pcd", nullable = false)
    private boolean pcd;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoDO endereco;

    @OneToMany(
            mappedBy = "paciente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AgendamentoDO> agendamentos;

    public PacienteDO() {
        super();
    }

    public PacienteDO(Paciente paciente) {
        super(paciente);
        this.pcd = paciente.isPcd();
        this.endereco = new EnderecoDO(paciente.getEndereco());
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }

    public EnderecoDO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDO endereco) {
        this.endereco = endereco;
    }

    public List<AgendamentoDO> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoDO> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
