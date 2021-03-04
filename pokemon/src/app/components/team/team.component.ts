import { Component, OnInit } from '@angular/core';
import { element } from 'protractor';
import { Team } from 'src/app/models/team';
import { PokeapiService } from 'src/app/services/pokeapi.service';
import { TeamService } from 'src/app/services/team.service';


@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  pokemonList: string[] = ["Pikachu"];
  pokemonList2: number[] = [];
  teamList: Team[] = [];
  team: Team = this.teamList[0];
  pokemonToAdd: string = '';

  constructor(
    private teamService: TeamService,
    private pokeapiService: PokeapiService
  ) { }

  ngOnInit(): void {
    this.getTeams();
  }

  getTeam(name: string){
    this.teamService.getTeam(name).subscribe(dataResult => {
      console.log(dataResult);
    });
  }

  getTeams(){
    this.teamService.getTeams().subscribe(dataResult => {
      console.log(dataResult);
      this.teamList=dataResult;
    })
  }

  showPokemons(team: Team) {
this.getTeam(team.trainer.name);
    this.team = team;
  }

  addPokemon(pokemonToAdd: string){
    pokemonToAdd=pokemonToAdd.toLowerCase();
    this.pokeapiService.getPokemonByName(pokemonToAdd).subscribe(dataResult => {
      let pokedexId = dataResult.id;
      let id = 1;
      let pokemon = {id, pokedexId};
      this.team.pokemonList.push(pokemon);
      this.pokeapiService.addPokemon(this.team.id, pokedexId).subscribe(dataResult => {
      });
      this.getTeams();
    });
  }
}
