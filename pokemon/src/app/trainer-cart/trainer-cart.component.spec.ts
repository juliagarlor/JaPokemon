import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerCartComponent } from './trainer-cart.component';

describe('TrainerCartComponent', () => {
  let component: TrainerCartComponent;
  let fixture: ComponentFixture<TrainerCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
