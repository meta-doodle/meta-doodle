import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceUpdateComponent } from 'app/entities/workflow-instance/workflow-instance-update.component';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { WorkflowInstance } from 'app/shared/model/workflow-instance.model';

describe('Component Tests', () => {
  describe('WorkflowInstance Management Update Component', () => {
    let comp: WorkflowInstanceUpdateComponent;
    let fixture: ComponentFixture<WorkflowInstanceUpdateComponent>;
    let service: WorkflowInstanceService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(WorkflowInstanceUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowInstanceUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowInstanceService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new WorkflowInstance(123);
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
        const entity = new WorkflowInstance();
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
