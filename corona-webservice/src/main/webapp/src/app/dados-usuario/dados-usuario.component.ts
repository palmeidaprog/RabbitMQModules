import { Component, OnInit } from '@angular/core';
import { DadosUsuarioService } from './dados-usuario.service';

@Component({
  selector: 'app-dados-usuario',
  templateUrl: './dados-usuario.component.html',
  styleUrls: ['./dados-usuario.component.css']
})
export class DadosUsuarioComponent implements OnInit {

  DadosUsuarioService: DadosUsuarioService;
  constructor() { }

  ngOnInit(): void {
  }

  criar(){
    
  }
}
