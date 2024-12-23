import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Classe } from '../models/classe.model';

@Injectable({
  providedIn: 'root'
})
export class ClasseService {
  private apiUrl = 'http://localhost:8080/api/classes';

  constructor(private http: HttpClient) { }

  getClasses(): Observable<Classe[]> {
    return this.http.get<Classe[]>(this.apiUrl);
  }

  getClasse(id: number): Observable<Classe> {
    return this.http.get<Classe>(`${this.apiUrl}/${id}`);
  }

  createClasse(classe: Classe): Observable<Classe> {
    return this.http.post<Classe>(this.apiUrl, classe);
  }

  updateClasse(id: number, classe: Classe): Observable<Classe> {
    return this.http.put<Classe>(`${this.apiUrl}/${id}`, classe);
  }

  deleteClasse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
