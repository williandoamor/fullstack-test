import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Cidade } from '../models/cidade'; 

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

   url = 'http://localhost:8080/temperatura/cidade/' /*Faz a chamada a api rest*/
   name : String;

   /*Injeta o HttpClient*/  
  constructor(private httpClient: HttpClient) { }

  /*Passa as opçoes de leitura para a api rest*/
  httpOptions = {

    headers: new HttpHeaders({ 'Content-Type': 'application/json'})

  }

  /*Exibe os dados da cidade*/
  getCidades(nome : String): Observable<Cidade>{  
   
    
    return this.httpClient.get<Cidade>(this.url + nome)
    .pipe(

      retry(2),
      catchError(this.handleError))
          
  }

  /*Manipulacoa de erros*/
  handleError(error: HttpErrorResponse) {


    var errorMessage = '';
    if (error.error instanceof ErrorEvent) {

      /*Erro ocorreu do lado do cliente*/
      errorMessage = error.error.message;

    }else {

      /*Ocorreu um erro do lado do servidor*/
      errorMessage = 'Código do erro: ${error.status}, ' + ' menssagem: ${error.message}';
     }

    console.log(errorMessage);
    return throwError(errorMessage);

  }

}
