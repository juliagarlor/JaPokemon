import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { TrainerDTO } from '../classes/trainer-dto';
import { TrainerService } from '../sevices/trainer.service';

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

  constructor(
    private trainerService: TrainerService
    ) { }

  ngOnInit(): void {
    this.getTrainerList();
  }

  createTrainer(): void {
    const trainerDTO = new TrainerDTO(this.name, this.age, this.hobby, this.photo);
    console.log(trainerDTO);
    this.trainerService.createTrainer(trainerDTO).subscribe(dataResult => {
      this.getTrainerList()
    });
  }

  getTrainerList(): void {

    this.trainerService.getTrainers()
    .subscribe( resp => {

      console.log(resp);

    } );
  }

}
