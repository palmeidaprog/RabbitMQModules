import { Component, OnInit } from '@angular/core';
import { FormularioService } from '../formulario.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AvisoComponent } from '../aviso/aviso.component';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {

  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AvisoComponent, {
      width: '600',
      height: '600',

    });


  }



}
