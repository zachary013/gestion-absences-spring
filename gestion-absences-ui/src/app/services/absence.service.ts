import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Absence } from '../models/absence.model';

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {
  private apiUrl = 'http://localhost:8080/api/absences';

  constructor(private http: HttpClient) { }

  getAbsences(): Observable<Absence[]> {
    return this.http.get<Absence[]>(this.apiUrl);
  }

  getAbsence(id: number): Observable<Absence> {
    return this.http.get<Absence>(`${this.apiUrl}/${id}`);
  }

  createAbsence(absence: Absence): Observable<Absence> {
    return this.http.post<Absence>(this.apiUrl, absence);
  }

  updateAbsence(id: number, absence: Absence): Observable<Absence> {
    return this.http.put<Absence>(`${this.apiUrl}/${id}`, absence);
  }

  deleteAbsence(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

