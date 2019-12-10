import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/service/pet-service.service';
import { Pet } from 'src/model/pet';

@Component({
  selector: 'app-petnew',
  templateUrl: './petnew.component.html',
  styleUrls: ['./petnew.component.css']
})
export class PetnewComponent implements OnInit {

  pet: Pet;
  isPetSaved: boolean;

  constructor(private petService: PetService) { 
    this.pet = new Pet();
    this.isPetSaved = false;
  }

  ngOnInit() {
  }

  onSubmit() {
    this.petService.savePet(this.pet).subscribe(result => {
      if (result.id !== null) {
        this.isPetSaved = true;
      } 
    });
  }

}
