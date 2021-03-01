import { Component, Input, OnInit } from '@angular/core';
import { Pokemon } from '../models/pokemon';
import { PokeapiService } from '../services/pokeapi.service';

@Component({
  selector: 'app-pokemon-card',
  templateUrl: './pokemon-card.component.html',
  styleUrls: ['./pokemon-card.component.css']
})
export class PokemonCardComponent implements OnInit {

  isActive: boolean = false;
  pokemon: Pokemon = new Pokemon(0,"-","-",["-","-"],0,0,0,0,0,0,[],0,0,"-","-",false);
  @Input() pokedexId: number = 0;
  pokemonList: Pokemon[] = [];

  constructor(
    private pokeapiService: PokeapiService
  ) { }

  ngOnInit(): void {
    this.getPokemon(this.pokedexId);
  }


  toggleActive(){
    if (this.isActive === false) {
      this.isActive = true;
    } else {
      this.isActive = false;
    }
  }

  getPokemon(pokedexId: number) {
    this.pokeapiService.getPokemon(pokedexId).subscribe(dataResult => {
      let types: string[] = [];
      dataResult.types.forEach(type => types.push(type.type.name));

      let abilities: {ability: {name: string}, is_hidden: boolean}[] = [];
      dataResult.abilities.forEach(abilityApi => abilities.push(abilityApi));

      this.pokemon = new Pokemon(
        dataResult.id,
        this.calculateGeneration(dataResult.id),
        dataResult.name,
        types,
        dataResult.stats[0].base_stat,
        dataResult.stats[1].base_stat,
        dataResult.stats[2].base_stat,
        dataResult.stats[3].base_stat,
        dataResult.stats[4].base_stat,
        dataResult.stats[5].base_stat,
        abilities,
        dataResult.height,
        dataResult.weight,
        dataResult.sprites.front_default,
        dataResult.sprites.front_default,
        false
      );
      
    });
  }
  calculateGeneration(pokedexId: number): string {
    if (pokedexId <= 151) {
      return "I";
    } else if (pokedexId > 151 && pokedexId <= 251) {
      return "II";
    } else if (pokedexId > 251 && pokedexId <= 386) {
      return "III";
    } else if (pokedexId > 386 && pokedexId <= 493) {
      return "IV";
    } else if (pokedexId > 493 && pokedexId <= 649) {
      return "V";
    } else if (pokedexId > 649 && pokedexId <= 721) {
      return "VI";
    } else if (pokedexId > 721 && pokedexId <= 809) {
      return "VII";
    } else {
      return "VIII";
    }
  }

}
