import { Component, OnInit } from '@angular/core';
import { Pet } from 'src/model/pet/pet';
import { PetService } from 'src/service/pet-service.service';

@Component({
  selector: 'app-petlist',
  templateUrl: './petlist.component.html',
  styleUrls: ['./petlist.component.css']
})
export class PetlistComponent implements OnInit {

  private pets: Pet[];

  constructor(private petService: PetService) { }

  ngOnInit() {
    this.petService.findAll().subscribe(data => {
      this.pets = data;
    });
  }

}
