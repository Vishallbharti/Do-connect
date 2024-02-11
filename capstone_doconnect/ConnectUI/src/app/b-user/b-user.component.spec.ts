import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BUserComponent } from './b-user.component';

describe('BUserComponent', () => {
  let component: BUserComponent;
  let fixture: ComponentFixture<BUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
