import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private url: string = "http://localhost:8080/";

  constructor(
    private http: HttpClient,
  ) { }

  getTeam(name: string): Observable<Team[]> {
    const url = `${this.url}/team/trainer/${name}`;
    return this.http.get<Team[]>(url);
  }

  getTeams(): Observable<Team[]> {
    const url = `${this.url}/teams`;
    return this.http.get<Team[]>(url);
  }

}
