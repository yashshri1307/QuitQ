import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDisplayallComponent } from './admin-displayall.component';

describe('AdminDisplayallComponent', () => {
  let component: AdminDisplayallComponent;
  let fixture: ComponentFixture<AdminDisplayallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDisplayallComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDisplayallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
