import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { CurrentStepDetailComponent } from 'app/entities/current-step/current-step-detail.component';
import { CurrentStep } from 'app/shared/model/current-step.model';

describe('Component Tests', () => {
  describe('CurrentStep Management Detail Component', () => {
    let comp: CurrentStepDetailComponent;
    let fixture: ComponentFixture<CurrentStepDetailComponent>;
    const route = ({ data: of({ currentStep: new CurrentStep(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [CurrentStepDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CurrentStepDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CurrentStepDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load currentStep on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.currentStep).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
