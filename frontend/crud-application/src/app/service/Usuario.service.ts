import { Injectable } from '@angular/core';
import { catchError, map } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Usuario } from './Usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  // Node/Express API
  REST_API: string = 'http://localhost:8090/api/usuario/v1';

  // Http Header
  httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private httpClient: HttpClient) {}


    // Obtem todos
    obterTodos() {
      return this.httpClient.get(`${this.REST_API}/todos`);
    }

  // Adiciona novo usuario
  adicionarNovo(tela: any): Observable<any> {

    let API_URL = `${this.REST_API}/adicionar`;
    console.log(tela);
    
    return this.httpClient
      .post(API_URL, tela)
      .pipe(catchError(this.handleError));
  }

  // Obtem usuario pelo id
  obterUsuarioPorId(id: any): Observable<any> {
    let API_URL = `${this.REST_API}/${id}`;
    return this.httpClient.get(API_URL, { headers: this.httpHeaders }).pipe(
      map((res: any) => {
        return res || {};
      }),
      catchError(this.handleError)
    );
  }

  // Update
  updateUser(id: any, data: any): Observable<any> {
    let API_URL = `${this.REST_API}/atualizar/${id}`;
    return this.httpClient
      .put(API_URL, data, { headers: this.httpHeaders })
      .pipe(catchError(this.handleError));
  }

  // Delete
  removerUsuario(id: any): Observable<any> {
    let API_URL = `${this.REST_API}/remover/${id}`;
    return this.httpClient
      .delete(API_URL, { headers: this.httpHeaders })
      .pipe(catchError(this.handleError));
  }

  // Error
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Handle client error
      errorMessage = error.error.message;
    } else {
      // Handle server error
      errorMessage = `Codigo de erro: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(() => {
      errorMessage;
    });
  }
}
