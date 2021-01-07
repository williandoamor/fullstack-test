import { Component } from '@angular/core';
import { CidadeService } from './services/cidade.service';
import { Cidade } from './models/cidade';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'consulta-temperatura';
    cidade = {} as Cidade;
    cidades: Cidade[];
    nomeCidade: String;
    getNomeCidade(valor: String) {

      console.warn(valor);
      this.nomeCidade = valor;
      this.getCidades(valor)
    }

    constructor(private cidadeService: CidadeService) {}
   

   /*Chama o serviço para obter os dados da cidade*/
   getCidades(nome: String) {
     
     this.cidadeService.getCidades(nome).subscribe((cidades: Cidade) => {
       
      if (cidades.status == 200) {

        this.cidades = cidades.object;
        console.log(this.cidades)     
        
      }
      
    
     });

   }

   /*Limpa o formulario*/
   cleanForm(form: NgForm) {

    this.getCidades(name);
    form.resetForm

   }


}
