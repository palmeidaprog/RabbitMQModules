import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../formulario.service';
import { MatDialog } from '@angular/material/dialog';
import { AvisoComponent } from '../aviso/aviso.component';
import { Agendamento } from "../entities/agendamento";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  constructor(public dialog: MatDialog, private formularioService: FormularioService, private formBuilder: FormBuilder) {

  }
  submitted = false;
  registerForm: FormGroup;
  agendamento: Agendamento;

  ngOnInit(): void {

    this.agendamento = new Agendamento();

    this.registerForm = this.formBuilder.group({
      nome: ['', Validators.required],
      sobrenome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      sexo: ['', Validators.required],
      rua: ['', Validators.required],
      numero: ['', Validators.required],
      cep: ['', Validators.required]
    });

  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AvisoComponent, {
      width: '600',
      height: '600',

    });


  }

  get f() {
    return this.registerForm.controls;
  }

  enviar() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }
   
    this.formularioService.adicionarAgendamento(this.agendamento);
    this.agendamento = new Agendamento();
    this.submitted = false;
    this.openDialog();
    
    
    

  }


}
