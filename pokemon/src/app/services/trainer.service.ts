import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trainer } from '../models/trainer';
import { TrainerDTO } from '../models/trainer-dto';


@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  private url: string = "http://localhost:8080/";

  constructor( 
    private http: HttpClient 
    ) { }

  getTrainers(): Observable<Trainer[]> {

    const url = `${this.url}trainers`;

     return this.http.get<Trainer[]>( url );
  }

  createTrainer(trainerDTO: TrainerDTO): Observable<TrainerDTO> {

    const url = `${this.url}trainer`;
    return this.http.post<TrainerDTO>( url, trainerDTO );

  }

  deleteTrainer(id: number): Observable<TrainerDTO>{

    const url = `${this.url}trainer/${id}`
    return this.http.delete<TrainerDTO>(url)

  }
}
