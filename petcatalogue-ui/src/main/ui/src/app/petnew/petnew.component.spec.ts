import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetnewComponent } from './petnew.component';

describe('PetnewComponent', () => {
  let component: PetnewComponent;
  let fixture: ComponentFixture<PetnewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetnewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetnewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
