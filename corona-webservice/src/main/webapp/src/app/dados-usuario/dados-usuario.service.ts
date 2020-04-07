import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DadosUsuarioService {
  
  usuarioUrl = 'http://localhost:8080/api/agendamento/criar';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  constructor(private http: HttpClient) { 

  }

  adicionar(object: any ){
    this.http.post<any>(this.usuarioUrl, object, this.httpOptions);
  }

}
