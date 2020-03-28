import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { CurrentStepUpdateComponent } from 'app/entities/current-step/current-step-update.component';
import { CurrentStepService } from 'app/entities/current-step/current-step.service';
import { CurrentStep } from 'app/shared/model/current-step.model';

describe('Component Tests', () => {
  describe('CurrentStep Management Update Component', () => {
    let comp: CurrentStepUpdateComponent;
    let fixture: ComponentFixture<CurrentStepUpdateComponent>;
    let service: CurrentStepService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [CurrentStepUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CurrentStepUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CurrentStepUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CurrentStepService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CurrentStep(123);
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
        const entity = new CurrentStep();
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
