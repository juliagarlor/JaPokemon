import { Component, OnInit } from '@angular/core';
import { TeamService } from '../sevices/team.service';

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {

  name:string = "";
  age: number | undefined;
  hobby: string =  "";
  photo: string = "";

  constructor(
    private teamService: TeamService
    ) { }

  ngOnInit(): void {
    this.getTrainerList();
  }

  createTrainer(): void {

  }

  getTrainerList(): void {

    this.teamService.getTrainers()
    .subscribe( resp => {
      
      console.log(resp);
    } );
  }

}
