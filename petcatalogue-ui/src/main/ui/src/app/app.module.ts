import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetlistComponent } from './petlist/petlist.component';
import { HttpClientModule } from '@angular/common/http';
import { PetService } from 'src/service/petservice/pet-service.service';
import { PetnewComponent } from './petnew/petnew.component';
import { FormsModule} from '@angular/forms';
import { OwnernewComponent } from './ownernew/ownernew.component';
import { OwnerService } from 'src/service/ownerservice/ownerservice.service';

@NgModule({
  declarations: [
    AppComponent,
    PetlistComponent,
    PetnewComponent,
    OwnernewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PetService, OwnerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
