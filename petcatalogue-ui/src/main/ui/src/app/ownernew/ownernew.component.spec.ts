import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnernewComponent } from './ownernew.component';

describe('OwnernewComponent', () => {
  let component: OwnernewComponent;
  let fixture: ComponentFixture<OwnernewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnernewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnernewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
