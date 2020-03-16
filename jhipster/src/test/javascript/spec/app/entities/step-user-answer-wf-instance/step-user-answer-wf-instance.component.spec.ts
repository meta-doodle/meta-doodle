import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { StepUserAnswerWfInstanceComponent } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance.component';
import { StepUserAnswerWfInstanceService } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance.service';
import { StepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';

describe('Component Tests', () => {
  describe('StepUserAnswerWfInstance Management Component', () => {
    let comp: StepUserAnswerWfInstanceComponent;
    let fixture: ComponentFixture<StepUserAnswerWfInstanceComponent>;
    let service: StepUserAnswerWfInstanceService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [StepUserAnswerWfInstanceComponent],
        providers: []
      })
        .overrideTemplate(StepUserAnswerWfInstanceComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(StepUserAnswerWfInstanceComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(StepUserAnswerWfInstanceService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new StepUserAnswerWfInstance(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.stepUserAnswerWfInstances && comp.stepUserAnswerWfInstances[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
