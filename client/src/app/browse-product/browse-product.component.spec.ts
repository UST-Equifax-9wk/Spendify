import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowseProductComponent } from './browse-product.component';

describe('BrowseProductComponent', () => {
  let component: BrowseProductComponent;
  let fixture: ComponentFixture<BrowseProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BrowseProductComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BrowseProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
