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
  age: number = 0;
  hobby: string =  "";
  photo: string = "";

  trainerList: Trainer[] = [];

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

  deleteTrainer(id: number): void {
    this.trainerService.deleteTrainer(id)
    .subscribe( resp => {
      console.log(resp);
    })
  }

}
