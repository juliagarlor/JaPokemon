import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../models/pokemon';
import { PokeapiService } from '../services/pokeapi.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  pokemonList: Pokemon[] = [];
  pokemon: Pokemon = new Pokemon(0,"-","-",["-","-"],0,0,0,0,0,0,[],0,0,"-","-",false);
  initialPokemon: number = 1;

  constructor(
    private pokeapiService: PokeapiService
  ) { }

  ngOnInit(): void {
    this.renderPokemonList();
  }

  getPokemon(id: number) {
    this.pokeapiService.getPokemon(id).subscribe(dataResult => {
      let types: string[] = [];
      dataResult.types.forEach(type => types.push(type.type.name));

      let abilities: {ability: {name: string}, is_hidden: boolean}[] = [];
      dataResult.abilities.forEach(abilityApi => abilities.push(abilityApi));

      this.pokemonList.push(new Pokemon(
        dataResult.id,
        PokedexComponent.calculateGeneration(dataResult.id),
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
        dataResult.sprites.other['official-artwork'].front_default,
        false
      ))
      this.pokemonList.sort((a,b) => (a.pokedexEntry < b.pokedexEntry ? -1 : 1));
    });
  }

  capitalize(string: string): string{
    return string.charAt(0).toLocaleUpperCase()+string.slice(1);
  }

  swapShow(pokemon: Pokemon){
    this.pokemon.show = false;
    this.pokemon = pokemon;
    this.pokemon.show = true;
  }

  plus15(){
    this.initialPokemon+=15;
    this.renderPokemonList();
  }
  minus15(){
    this.initialPokemon-=15;
    this.renderPokemonList();
  }

  renderPokemonList(){
    this.pokemonList=[];
    for (let i = this.initialPokemon; i < this.initialPokemon + 15; i++) {
      this.getPokemon(i);
    }
  }

  static calculateGeneration(id: number): string {
    if (id <= 151) {
      return "I";
    } else if (id > 151 && id <= 251) {
      return "II";
    } else if (id > 251 && id <= 386) {
      return "III";
    } else if (id > 386 && id <= 493) {
      return "IV";
    } else if (id > 493 && id <= 649) {
      return "V";
    } else if (id > 649 && id <= 721) {
      return "VI";
    } else if (id > 721 && id <= 809) {
      return "VII";
    } else {
      return "VIII";
    }
  }
}
