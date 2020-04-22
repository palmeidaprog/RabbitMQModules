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
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class PacienteDO extends PessoaDO {

    @Column(name = "pcd", nullable = false)
    private boolean pcd;

    @ManyToOne(cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteDO)) return false;
        PacienteDO that = (PacienteDO) o;
        return pcd == that.pcd &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(agendamentos, that.agendamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcd, endereco, agendamentos);
    }
}
