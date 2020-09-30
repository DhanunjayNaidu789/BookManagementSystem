import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeCustomerByIdComponent } from './see-customer-by-id.component';

describe('SeeCustomerByIdComponent', () => {
  let component: SeeCustomerByIdComponent;
  let fixture: ComponentFixture<SeeCustomerByIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeCustomerByIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeCustomerByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
