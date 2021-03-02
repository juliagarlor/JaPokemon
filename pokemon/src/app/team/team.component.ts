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
      console.log(dataResult);
      this.teamList=dataResult;
    })
  
  //   let trainer: Trainer = new Trainer(1, "Pepe", 75, "Heráldica", "pepe.jpg");
  //   this.teamList=[
  //     {
  //         id: 1,
  //         trainer: this.trainer,
  //         pokemonList: [
  //             {
  //                 id: 1,
  //                 pokedexId: 129
  //             },
  //             {
  //                 id: 9,
  //                 pokedexId: 4
  //             },
  //             {
  //                 id: 21,
  //                 pokedexId: 132
  //             },
  //             {
  //                 id: 15,
  //                 pokedexId: 609
  //             },
  //             {
  //                 id: 28,
  //                 pokedexId: 172
  //             },
  //             {
  //                 id: 29,
  //                 pokedexId: 448
  //             }
  //         ]
  //     }
  // ]
  }

  showPokemons(team: Team) {
    this.team = team;
  }

  addPokemon(pokemonToAdd: string){
    pokemonToAdd=pokemonToAdd.toLowerCase();
    let pokemonId: number = 0;
    this.pokeapiService.getPokemonByName(pokemonToAdd).subscribe(dataResult => {
      let pokedexId = dataResult.id;
      let id = this.team.pokemonList[this.team.pokemonList.length-1].id +1;
      let pokemon = {id, pokedexId};
      this.team.pokemonList.push(pokemon);
      this.getTeams();
      this.pokeapiService.addPokemon(this.team.id, pokedexId).subscribe(dataResult => {
      });
      this.getTeams();
    });

  }
}
