import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DadosEnderecoService {

  endercoUrl = 'http://localhost:8080/api/agendamento/criar';

  constructor(private http: HttpClient) { 
    
  }

  adicionar(object: any ){
    this.http.post<any>(this.endercoUrl, object);
  }
  
}
