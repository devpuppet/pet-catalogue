import { TestBed } from '@angular/core/testing';

import { OwnerService } from './ownerservice.service';

describe('OwnerserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OwnerService = TestBed.get(OwnerService);
    expect(service).toBeTruthy();
  });
});
