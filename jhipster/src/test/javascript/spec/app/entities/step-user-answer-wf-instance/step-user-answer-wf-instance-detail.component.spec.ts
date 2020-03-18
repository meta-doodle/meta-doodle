import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { StepUserAnswerWfInstanceDetailComponent } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance-detail.component';
import { StepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';

describe('Component Tests', () => {
  describe('StepUserAnswerWfInstance Management Detail Component', () => {
    let comp: StepUserAnswerWfInstanceDetailComponent;
    let fixture: ComponentFixture<StepUserAnswerWfInstanceDetailComponent>;
    const route = ({ data: of({ stepUserAnswerWfInstance: new StepUserAnswerWfInstance(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [StepUserAnswerWfInstanceDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(StepUserAnswerWfInstanceDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(StepUserAnswerWfInstanceDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load stepUserAnswerWfInstance on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.stepUserAnswerWfInstance).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
