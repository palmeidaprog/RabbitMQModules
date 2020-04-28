import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Agendamento} from "./entities/agendamento";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  url = 'http://localhost:8080/agendamento/create';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {

  }

  adicionarAgendamento(agendamento: Agendamento): Observable<any> {
    return this.http.post<Agendamento>(this.url, agendamento, this.httpOptions);
  }

  adicionarPaciente(object: any ){
    this.http.post<any>(this.url, object, this.httpOptions);
  }

  adicionarEndereco(object: any ){
    this.http.post<any>(this.url, object, this.httpOptions);
  }

}
