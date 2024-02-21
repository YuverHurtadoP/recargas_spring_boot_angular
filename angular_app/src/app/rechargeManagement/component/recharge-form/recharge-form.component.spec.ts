import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechargeFormComponent } from './recharge-form.component';

describe('RechargeFormComponent', () => {
  let component: RechargeFormComponent;
  let fixture: ComponentFixture<RechargeFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RechargeFormComponent]
    });
    fixture = TestBed.createComponent(RechargeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
