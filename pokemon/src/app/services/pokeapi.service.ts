import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokeapiService {

  url: string = 'https://pokeapi.co/api/v2/pokemon';

  constructor(
    private http: HttpClient,
  ) { }

  getPokemon(id: number): Observable<PokemonFromApi> {
    const url: string = this.url + '/' + id
    return this.http.get<PokemonFromApi>(url);
  }
  getPokemonByName(name: string): Observable<PokemonFromApi> {
    const url = this.url + '/' + name;
    return this.http.get<PokemonFromApi>(url );
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