import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { DadosUsuarioComponent } from './dados-usuario/dados-usuario.component';
import { DadosEnderecoComponent } from './dados-endereco/dados-endereco.component';

@NgModule({
  declarations: [
    AppComponent,
    DadosUsuarioComponent,
    DadosEnderecoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
