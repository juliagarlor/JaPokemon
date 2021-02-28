export class TrainerDTO {
    
    constructor(
        _name: string,
        _age: number,
        _hobby: string,
        _photo: string
    ){}

    
    public get name() : string {
        return this.name;
    }
    
    public get age() : number {
        return this.age;
    }
   
    public get hobby() : string {
        return this.hobby;
    }
    
    public get photo() : string {
        return this.photo;
    }

    
    public set name(v : string) {
        this.name = v;
    }
    
    public set age(v : number) {
        this.age = v;
    }
    
    public set hobby(v : string) {
        this.hobby = v;
    }
    
    public set photo(v : string) {
        this.photo = v;
    }

}
