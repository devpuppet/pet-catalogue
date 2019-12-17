import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from 'src/model/owner/owner';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private saveOwnerUrl = 'http://localhost:8080/owner/new';

  constructor(private http: HttpClient) { }

saveOwner(owner: Owner): Observable<Owner> {
  return this.http.post<Owner>(this.saveOwnerUrl, owner);
}

}
