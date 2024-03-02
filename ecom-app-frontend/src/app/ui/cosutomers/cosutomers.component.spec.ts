import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CosutomersComponent } from './cosutomers.component';

describe('CosutomersComponent', () => {
  let component: CosutomersComponent;
  let fixture: ComponentFixture<CosutomersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CosutomersComponent]
    });
    fixture = TestBed.createComponent(CosutomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
