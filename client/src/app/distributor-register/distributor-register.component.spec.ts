import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistributorRegisterComponent } from './distributor-register.component';

describe('DistributorRegisterComponent', () => {
  let component: DistributorRegisterComponent;
  let fixture: ComponentFixture<DistributorRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DistributorRegisterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DistributorRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
