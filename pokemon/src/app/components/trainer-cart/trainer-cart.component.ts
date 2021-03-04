import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Trainer } from 'src/app/models/trainer';

@Component({
  selector: 'app-trainer-cart',
  templateUrl: './trainer-cart.component.html',
  styleUrls: ['./trainer-cart.component.css']
})
export class TrainerCartComponent implements OnInit {

  isActive: boolean = false;
  @Input() trainer!: Trainer;

  @Output() deleteTrainerEvent = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  toggleActive(){
    if (this.isActive === false) {
      this.isActive = true;
    } else {
      this.isActive = false;
    }
  }

  delete(): void{
    this.deleteTrainerEvent.emit(this.trainer.id)
  }

}
