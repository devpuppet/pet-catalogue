import { Component, OnInit } from '@angular/core';
import { Owner } from 'src/model/owner/owner';
import { OwnerService } from 'src/service/ownerservice/ownerservice.service';

@Component({
  selector: 'app-ownernew',
  templateUrl: './ownernew.component.html',
  styleUrls: ['./ownernew.component.css']
})
export class OwnernewComponent implements OnInit {

isOwnerSaved: boolean;
owner: Owner;

  constructor(private ownerService: OwnerService) { 
    this.owner = new Owner();
    this.isOwnerSaved = false;
  }

  ngOnInit() {
  }

  onSubmit() {
    this.ownerService.saveOwner(this.owner).subscribe(result => {
      if (result.id !== null) {
        this.isOwnerSaved = true;
      }
    })
  }

}
