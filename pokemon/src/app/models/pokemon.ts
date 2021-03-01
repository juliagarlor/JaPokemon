export class Pokemon {
    constructor(
        private _pokedexEntry: number,
        private _generation: string,
        private _name: string,
        private _types: string[],
        private _hp: number,
        private _attack: number,
        private _defense: number,
        private _specialAttack: number,
        private _specialDefense: number,
        private _speed: number,
        private _abilities: {ability: {name: string}, is_hidden: boolean}[],
        private _height: number,
        private _weight: number,
        private _sprite: string,
        private _artwork: string,
        private _show: boolean
      ){}

      get pokedexEntry(): number {
        return this._pokedexEntry;
      }
      get generation(): string {
        return this._generation;
      }
      get name(): string {
          return this._name;
      }
      get types(): string[] {
          return this._types;
      }
      get hp(): number {
        return this._hp;
      }
      get attack(): number {
        return this._attack;
      }
      get defense(): number {
        return this._defense;
      }
      get specialAttack(): number {
        return this._specialAttack;
      }
      get specialDefense(): number {
        return this._specialDefense;
      }
      get speed(): number {
        return this._speed;
      }
      get abilities(): {ability: {name: string}, is_hidden: boolean}[] {
        return this._abilities;
      }
      get height(): number {
        return this._height;
      }
      get weight(): number {
        return this._weight;
      }
      get sprite(): string {
          return this._sprite;
      }
      get artwork(): string {
          return this._artwork;
      }
      get show(): boolean {
          return this._show;
      }

      set pokedexEntry(pokedexEntry: number) {
        this._pokedexEntry = pokedexEntry;
      }
      set generation(generation: string) {
        this._generation = generation;
      }
      set name(name: string) {
        this._name = name;
      }
      set types(types: string[]) {
        this._types = types;
      }
      set hp(hp: number) {
        this._hp = hp;
      }
      set attack(attack: number) {
        this._attack = attack;
      }
      set defense(defense: number) {
        this._defense = defense;
      }
      set specialAttack(specialAttack: number) {
        this._specialAttack = specialAttack;
      }
      set specialDefense(specialDefense: number) {
        this._specialDefense = specialDefense;
      }
      set speed(speed: number) {
        this._speed = speed;
      }
      set abilities(abilities: {ability: {name: string}, is_hidden: boolean}[]) {
        this._abilities = abilities;
      }
      set height(height: number) {
        this._height = height;
      }
      set weight(weight: number) {
        this._weight = weight;
      }
      set sprite(sprite: string) {
        this._sprite = sprite;
      }
      set artwork(artwork: string) {
        this._artwork = artwork;
      }
      set show(show: boolean) {
        this._show = show;
      }
}
