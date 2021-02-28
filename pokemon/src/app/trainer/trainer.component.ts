import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit(): void {
  }

  createTrainer(): void {

  }

}
