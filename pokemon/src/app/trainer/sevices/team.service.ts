import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private url: string = "localhost:8080/";

  constructor( 
    private http: HttpClient 
    ) { }

  getTrainers(): Observable<any> {

    const url = `${this.url}trainers`

     return this.http.get( url );
  }
  getTrainerById(id: string): Observable<any> {

    const url = `${this.url}trainer/${id}`

    return this.http.get( url );
  }

}
