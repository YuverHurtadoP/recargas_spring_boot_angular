import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechargeListComponent } from './recharge-list.component';

describe('RechargeListComponent', () => {
  let component: RechargeListComponent;
  let fixture: ComponentFixture<RechargeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RechargeListComponent]
    });
    fixture = TestBed.createComponent(RechargeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
