import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../formulario.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AvisoComponent } from '../aviso/aviso.component';
import {Agendamento} from "../entities/agendamento";
@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  constructor(public dialog: MatDialog, private formularioService: FormularioService) { 

  }

  agendamento: Agendamento;

  ngOnInit(): void {
    this.agendamento = new Agendamento();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AvisoComponent, {
      width: '600',
      height: '600',

    });


  }


  enviar(){
    this.formularioService.adicionarAgendamento(this.agendamento);
    this.agendamento = new Agendamento();
  }



}
