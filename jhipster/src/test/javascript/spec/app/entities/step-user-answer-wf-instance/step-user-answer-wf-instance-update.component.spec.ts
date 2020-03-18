import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { StepUserAnswerWfInstanceUpdateComponent } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance-update.component';
import { StepUserAnswerWfInstanceService } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance.service';
import { StepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';

describe('Component Tests', () => {
  describe('StepUserAnswerWfInstance Management Update Component', () => {
    let comp: StepUserAnswerWfInstanceUpdateComponent;
    let fixture: ComponentFixture<StepUserAnswerWfInstanceUpdateComponent>;
    let service: StepUserAnswerWfInstanceService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [StepUserAnswerWfInstanceUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(StepUserAnswerWfInstanceUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(StepUserAnswerWfInstanceUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(StepUserAnswerWfInstanceService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new StepUserAnswerWfInstance(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new StepUserAnswerWfInstance();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
