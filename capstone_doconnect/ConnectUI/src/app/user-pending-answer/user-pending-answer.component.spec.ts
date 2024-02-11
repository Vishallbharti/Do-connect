import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPendingAnswerComponent } from './user-pending-answer.component';

describe('UserPendingAnswerComponent', () => {
  let component: UserPendingAnswerComponent;
  let fixture: ComponentFixture<UserPendingAnswerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPendingAnswerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPendingAnswerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
