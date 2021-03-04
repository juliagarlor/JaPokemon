import { Trainer } from './trainer';



export class Team {
    constructor(
        private _id: number,
        private _trainer: Trainer,
        private _pokemonList: {id: number, pokedexId:number}[],
    ){}

    get id(): number {
        return this._id;
    }
    get trainer(): Trainer {
        return this._trainer;
    }
    get pokemonList(): {id: number, pokedexId:number}[] {
        return this._pokemonList;
    }

    set id(id: number) {
        this._id = id;
    }
    set trainer(trainer: Trainer) {
        this._trainer = trainer;
    }
    set pokemonList(pokemonList: {id: number, pokedexId:number}[]) {
        this._pokemonList = pokemonList;
    }
}





