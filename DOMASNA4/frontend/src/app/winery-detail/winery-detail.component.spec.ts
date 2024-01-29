import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WineryDetailComponent } from './winery-detail.component';

describe('WineryDetailComponent', () => {
  let component: WineryDetailComponent;
  let fixture: ComponentFixture<WineryDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WineryDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WineryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
