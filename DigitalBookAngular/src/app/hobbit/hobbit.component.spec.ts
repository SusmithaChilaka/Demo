import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HobbitComponent } from './hobbit.component';

describe('HobbitComponent', () => {
  let component: HobbitComponent;
  let fixture: ComponentFixture<HobbitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HobbitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HobbitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
