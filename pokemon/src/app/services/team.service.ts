import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private url: string = "http://localhost:8080";

  constructor(
    private http: HttpClient,
  ) { }

  getTeam(teamId: number): Observable<Team> {
    const url = `${this.url}/team/${teamId}`;
    return this.http.get<Team>(url);
  }

  getTeamsIdAndTrainersName() : Observable<{teamId: number, trainerName: string}[]> {
    const url = `${this.url}/teams/menu-list`;
    return this.http.get<{teamId: number, trainerName: string}[]>(url);
  }

  addPokemon(teamId: number, pokedexId: number): Observable<any> {
    const url = `${this.url}/add/${teamId}/team-mate`;
    return this.http.put<any>(url, pokedexId);
  }

  removePokemon(pokemonId: number, teamId: number): Observable<any> {
    const url = `${this.url}/remove/${teamId}/team-mate`;
    return this.http.put<any>(url, pokemonId);
  }
}