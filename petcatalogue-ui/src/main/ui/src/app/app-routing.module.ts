import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PetlistComponent } from './petlist/petlist.component';
import { PetnewComponent } from './petnew/petnew.component';
import { OwnernewComponent } from './ownernew/ownernew.component';


const routes: Routes = [
  { path: 'pets', component: PetlistComponent },
  { path: 'petnew', component: PetnewComponent },
  { path: 'ownernew', component: OwnernewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
