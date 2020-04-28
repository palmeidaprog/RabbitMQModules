import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../formulario.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AvisoComponent } from '../aviso/aviso.component';
import {FormControl, FormGroup} from "@angular/forms";
import {Paciente} from "../entities/paciente";
import {PessoaSexo} from "../entities/pessoa-sexo.enum";
import {Endereco} from "../entities/endereco";
import {Agendamento} from "../entities/agendamento";

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  dataAgendamentoCtrl: FormControl = new FormControl("");
  pacienteForm: FormGroup;
  enderecoForm: FormGroup;

  // paciente
  nomeCtrl: FormControl = new FormControl("");
  sobrenomeCtrl: FormControl = new FormControl("");
  dataNascimentoCtrl: FormControl = new FormControl("");
  cpfCtrl: FormControl = new FormControl("");
  rgCtrl: FormControl = new FormControl("");
  sexoCtrl: FormControl = new FormControl("");
  pcdCtrl: FormControl = new FormControl(false);
  emailCtrl: FormControl = new FormControl("");

  // endereco
  ruaCtrl: FormControl = new FormControl("");
  numeroCtrl: FormControl = new FormControl("");
  complementoCtrl: FormControl = new FormControl("");
  cepCtrl: FormControl = new FormControl("");
  bairroCtrl: FormControl = new FormControl("");
  cidadeCtrl: FormControl = new FormControl("");
  estadoCtrl: FormControl = new FormControl("")

  constructor(public dialog: MatDialog,
              private formularioService: FormularioService) { }

  ngOnInit(): void {
    this.criaForumlarioEndereco();
    this.criaFormularioPaciente();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AvisoComponent, {
      width: '600',
      height: '600',

    });
  }

  /**
   * Cria formulario do paciente
   */
  criaFormularioPaciente(): void {
    this.pacienteForm = new FormGroup({
      nome: this.nomeCtrl,
      sobrenome: this.sobrenomeCtrl,
      dataNascimento: this.dataNascimentoCtrl,
      cpf: this.cpfCtrl,
      rg: this.rgCtrl,
      sexo: this.sexoCtrl,
      pcd: this.pcdCtrl,
      email: this.emailCtrl
    });
  }

  /**
   * Cria formulario do Endereco
   */
  criaForumlarioEndereco(): void {
    this.enderecoForm = new FormGroup({
      rua: this.ruaCtrl,
      numero: this.numeroCtrl,
      complemento: this.complementoCtrl,
      cep: this.cepCtrl,
      bairro: this.bairroCtrl,
      cidade: this.cidadeCtrl,
      estado: this.estadoCtrl
    });
  }

  /**
   * Extrai Agendamento do Formulario
   */
  getAgendamento(): Agendamento {
    const endereco: Endereco = Object.assign({}, this.enderecoForm.value);
    const paciente: Paciente = Object.assign({}, this.pacienteForm.value);
    paciente.endereco = endereco;
    const agendamento: Agendamento = new Agendamento();
    agendamento.dataAgendamento = new Date();
    agendamento.paciente = paciente;

    return agendamento;
  }

  async save(): Promise<void> {
    if (!this.pacienteForm.valid || !this.enderecoForm.valid) {
      return ;
    }

    await this.formularioService.adicionarAgendamento(this.getAgendamento())
      .toPromise()
      .then(() => this.openDialog())
      .catch(erro => window.alert("Erro ao enviar agendamento ao servidor!"));
  }

}
