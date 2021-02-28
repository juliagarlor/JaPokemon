import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeamComponent } from './team/team.component';
import { PokedexComponent } from './pokedex/pokedex.component';
import { TrainerComponent } from './trainer/trainer.component';

const routes: Routes = [
  {
    path: "team",
    component: TeamComponent
  },
  {
    path: "pokedex",
    component: PokedexComponent 
  },
  {
    path: "trainer",
    component: TrainerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
