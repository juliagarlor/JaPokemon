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

  pokemonList: number[] = [];
  pokemonIdList: number [] = [];
  teamList: {teamId: number, trainerName: string}[] = [];
  pokemonToAdd: string = '';
  teamId: number = 0;
  
  selectedTrainer: number = 0;

  constructor(
    private teamService: TeamService,
    private pokeapiService: PokeapiService
  ) { }

  ngOnInit(): void {
    this.getTeamsIdAndTrainersName();
  }

  getTeam(teamId: number){
    this.teamService.getTeam(teamId).subscribe(dataResult => {
      dataResult.pokemonList.forEach(pokemon => this.pokemonList.push(pokemon.pokedexId));
      dataResult.pokemonList.forEach(pokemon => this.pokemonIdList.push(pokemon.id));
    });
  }

  getTeamsIdAndTrainersName(){
    this.teamService.getTeamsIdAndTrainersName().subscribe(dataResult => {
      this.teamList = dataResult;
    })
  }

  showPokemons(teamId: number) {
    this.pokemonList=[];
    this.getTeam(teamId);
    this.teamId = teamId;
  }

  addPokemon(pokemonToAdd: string){
    if (this.pokemonList.length >= 7) {
      alert("Team can't hold more than 7 pokemons.");
    } else if (this.teamId === 0) {
      alert("Select a trainer first.");
    } else {
      pokemonToAdd=pokemonToAdd.toLowerCase();
      this.pokeapiService.getPokemonByName(pokemonToAdd).subscribe(dataResult => {
        this.teamService.addPokemon(this.teamId, dataResult.id).subscribe();
        this.pokemonList.push(dataResult.id);
      }, error => {
        alert(pokemonToAdd + " is not a valid Pokemon.");
      });
    }
  }

  removePokemon(pokemonId: number, teamId: number, index: number) {
    this.teamService.removePokemon(pokemonId, teamId).subscribe();
    this.pokemonList.splice(index, 1);
  }
}
