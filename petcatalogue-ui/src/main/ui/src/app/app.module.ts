import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetlistComponent } from './petlist/petlist.component';
import { HttpClientModule } from '@angular/common/http';
import { PetService } from 'src/service/pet-service.service';

@NgModule({
  declarations: [
    AppComponent,
    PetlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
