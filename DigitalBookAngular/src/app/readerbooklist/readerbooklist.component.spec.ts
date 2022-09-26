import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderbooklistComponent } from './readerbooklist.component';

describe('ReaderbooklistComponent', () => {
  let component: ReaderbooklistComponent;
  let fixture: ComponentFixture<ReaderbooklistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReaderbooklistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReaderbooklistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
