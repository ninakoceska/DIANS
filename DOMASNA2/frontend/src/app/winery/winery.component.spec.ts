import { ComponentFixture, TestBed } from '@angular/core/testing';

import { wineryComponent } from './winery.component';

describe('WineryComponent', () => {
  let component: wineryComponent;
  let fixture: ComponentFixture<wineryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [wineryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(wineryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
