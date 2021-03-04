import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokeapiService {

  constructor(
    private http: HttpClient,
  ) { }

  getPokemon(id: number): Observable<PokemonFromApi> {
    return this.http.get<PokemonFromApi>('https://pokeapi.co/api/v2/pokemon/'+id);
  }
  getPokemonByName(name: string): Observable<PokemonFromApi> {
    return this.http.get<PokemonFromApi>('https://pokeapi.co/api/v2/pokemon/'+name);
  }
  // /add/{teamId}/team-mate
  addPokemon(teamId: number, pokedexId: number): Observable<any> {
    return this.http.put<any>('http://localhost:8080/add/' + teamId + '/team-mate', pokedexId);
  }
}

interface PokemonFromApi {
  id: number,
  name: string,
  types: {
    type: {
      name: string
    }
  }[],
  stats: {
    base_stat: number,
    stat: {
      name: string
    }
  }[],
  abilities: {
    ability: {
      name: string
    },
    is_hidden: boolean
  }[],
  height: number,
  weight: number,
  sprites: {
    front_default: string
    other: {
      'official-artwork': {
        front_default: string
      }
    }
  }
}