import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceStateUpdateComponent } from 'app/entities/workflow-instance-state/workflow-instance-state-update.component';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';
import { WorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';

describe('Component Tests', () => {
  describe('WorkflowInstanceState Management Update Component', () => {
    let comp: WorkflowInstanceStateUpdateComponent;
    let fixture: ComponentFixture<WorkflowInstanceStateUpdateComponent>;
    let service: WorkflowInstanceStateService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceStateUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(WorkflowInstanceStateUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowInstanceStateUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowInstanceStateService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new WorkflowInstanceState(123);
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
        const entity = new WorkflowInstanceState();
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
