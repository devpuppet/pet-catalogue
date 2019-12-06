import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Pet } from 'src/model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  privateuserUrl: string;

  constructor(private http: HttpClient) { 
    this.privateuserUrl = 'http://localhost:8080/pets';
  }

public findAll(): Observable<Pet[]> {
  return this.http.get<Pet[]>(this.privateuserUrl);
  }

}
