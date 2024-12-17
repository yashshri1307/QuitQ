import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayInventoryComponent } from './display-inventory.component';

describe('DisplayInventoryComponent', () => {
  let component: DisplayInventoryComponent;
  let fixture: ComponentFixture<DisplayInventoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayInventoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
