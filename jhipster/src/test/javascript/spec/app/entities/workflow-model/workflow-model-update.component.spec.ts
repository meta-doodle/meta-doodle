import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowModelUpdateComponent } from 'app/entities/workflow-model/workflow-model-update.component';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';
import { WorkflowModel } from 'app/shared/model/workflow-model.model';

describe('Component Tests', () => {
  describe('WorkflowModel Management Update Component', () => {
    let comp: WorkflowModelUpdateComponent;
    let fixture: ComponentFixture<WorkflowModelUpdateComponent>;
    let service: WorkflowModelService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowModelUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(WorkflowModelUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowModelUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowModelService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new WorkflowModel(123);
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
        const entity = new WorkflowModel();
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
