import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteOrdersComponent } from './delete-orders.component';

describe('DeleteOrdersComponent', () => {
  let component: DeleteOrdersComponent;
  let fixture: ComponentFixture<DeleteOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
