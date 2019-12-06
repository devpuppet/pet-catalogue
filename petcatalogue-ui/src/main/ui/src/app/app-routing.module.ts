import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PetlistComponent } from './petlist/petlist.component';


const routes: Routes = [
  { path: 'pets', component: PetlistComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
