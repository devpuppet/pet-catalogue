import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetlistComponent } from './petlist/petlist.component';
import { HttpClientModule } from '@angular/common/http';
import { PetService } from 'src/service/pet-service.service';
import { PetnewComponent } from './petnew/petnew.component';
import { FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PetlistComponent,
    PetnewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
