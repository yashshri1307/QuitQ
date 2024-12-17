import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayProductCategoryComponent } from './display-product-category.component';

describe('DisplayProductCategoryComponent', () => {
  let component: DisplayProductCategoryComponent;
  let fixture: ComponentFixture<DisplayProductCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayProductCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayProductCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
