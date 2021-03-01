export class Trainer {

    constructor(
        private _id: number,
        private _name: string,
        private _age: number,
        private _hobby: string,
        private _photo: string
    ){}

    
    public get id() : number {
        return this._id;
    }
    
    public get name() : string {
        return this._name;
    }
    
    public get age() : number {
        return this._age;
    }
   
    public get hobby() : string {
        return this._hobby;
    }
    
    public get photo() : string {
        return this._photo;
    }

    
    public set id(v : number) {
        this._id = v;
    }
    
    public set name(v : string) {
        this._name = v;
    }
    
    public set age(v : number) {
        this._age = v;
    }
    
    public set hobby(v : string) {
        this._hobby = v;
    }
    
    public set photo(v : string) {
        this._photo = v;
    }


}
