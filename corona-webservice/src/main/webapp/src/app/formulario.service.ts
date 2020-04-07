import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  url = 'http://localhost:8080/api/agendamento/criar';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { 
    
  }

  adicionarPaciente(object: any ){
    this.http.post<any>(this.url, object, this.httpOptions);
  }

  adicionarEndereco(object: any ){
    this.http.post<any>(this.url, object, this.httpOptions);
  }

}
