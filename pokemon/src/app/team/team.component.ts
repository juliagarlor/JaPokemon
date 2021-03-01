import { Component, OnInit } from '@angular/core';
import { Team } from '../models/team';
import { PokeapiService } from '../services/pokeapi.service';
import { TeamService } from '../services/team.service';
import { Trainer } from '../trainer/classes/trainer';
import { TrainerService } from '../trainer/sevices/trainer.service';

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
      this.teamList=dataResult;
    })
  }

  showPokemons(team: Team) {
    this.team = team;
  }

  addPokemon(pokemonToAdd: string){
    pokemonToAdd=pokemonToAdd.toLowerCase();
    let pokemonId: number = 0;
    this.pokeapiService.getPokemonByName(pokemonToAdd).subscribe(dataResult => {
      pokemonId = dataResult.id;
      this.pokeapiService.addPokemon(this.team.id, pokemonId).subscribe(dataResult => {
        this.getTeams();
      });
    })
  }
}
