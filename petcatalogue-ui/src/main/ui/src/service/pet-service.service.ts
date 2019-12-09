import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Pet } from 'src/model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  findAllUrl = 'http://localhost:8080/pets';
  savePetUrl = 'http://localhost:8080/pet/new';

  constructor(private http: HttpClient) { 
  }

public findAll(): Observable<Pet[]> {
  return this.http.get<Pet[]>(this.findAllUrl);
  }

public savePet(pet: Pet) {
  return this.http.post<Pet>(this.savePetUrl, pet);
} 

}
