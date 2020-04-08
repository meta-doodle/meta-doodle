import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceStateComponent } from 'app/entities/workflow-instance-state/workflow-instance-state.component';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';
import { WorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';

describe('Component Tests', () => {
  describe('WorkflowInstanceState Management Component', () => {
    let comp: WorkflowInstanceStateComponent;
    let fixture: ComponentFixture<WorkflowInstanceStateComponent>;
    let service: WorkflowInstanceStateService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceStateComponent]
      })
        .overrideTemplate(WorkflowInstanceStateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowInstanceStateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowInstanceStateService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new WorkflowInstanceState(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.workflowInstanceStates && comp.workflowInstanceStates[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
