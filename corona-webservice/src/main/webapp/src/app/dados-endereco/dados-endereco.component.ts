import { Component, OnInit } from '@angular/core';
import { DadosEnderecoService } from './dados-endereco.service';

@Component({
  selector: 'app-dados-endereco',
  templateUrl: './dados-endereco.component.html',
  styleUrls: ['./dados-endereco.component.css']
})
export class DadosEnderecoComponent implements OnInit {

  DadosEnderecoService: DadosEnderecoService;
  constructor() { }

  ngOnInit(): void {
  }

  criar(){
    
  }

}
