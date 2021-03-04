import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Trainer } from 'src/app/models/trainer';
import { TrainerDTO } from 'src/app/models/trainer-dto';
import { TrainerService } from 'src/app/services/trainer.service';


@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {

  name:string = "";
  age!: number;
  hobby: string =  "";
  photo: string = "";

  photoList: string[] = ["chica.gif", "científica.gif", "criadora.gif", "duque.gif", "entrenador-guay.gif", "entrenadora-guay.gif", "guitarrista.gif", "joven.gif", "karateka.gif", "luchadora.gif", "modelo.gif", "montañero.gif", "motorista.gif", "pescador.gif", "policía.gif", "calvo.gif", "arlequín.gif", "ciclista-chico.gif", "ciclista-chica.gif", "marquesa.gif"];

  trainerList: Trainer[] = [];

  selectedPhoto: string= '';

  constructor(
    private trainerService: TrainerService
    ) { }

  ngOnInit(): void {
    this.getTrainerList();
  }

  createTrainer(): void {
    const trainerDTO = {name:this.name, age: this.age, hobby: this.hobby, photo: this.photo};
    console.log(trainerDTO);
    this.trainerService.createTrainer(trainerDTO).subscribe(dataResult => {
      this.getTrainerList()
    });
  }

  getTrainerList(): void {

    this.trainerService.getTrainers()
    .subscribe( resp => {
      this.trainerList = resp;
    } );
  }

  deleteTrainer(id: number, index: number): void {
    this.trainerService.deleteTrainer(id)
    .subscribe( resp => {
      console.log(resp);
    })
    this.trainerList.splice(index, 1);
  }

  normalize(text: string) {
    return (text.charAt(0).toLocaleUpperCase()+text.slice(1,-4)).replace("-", " ");
  }
  setPhoto(photo: string) {
    this.photo=photo;
  }

}
