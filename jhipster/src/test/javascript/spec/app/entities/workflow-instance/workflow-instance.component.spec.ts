import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceComponent } from 'app/entities/workflow-instance/workflow-instance.component';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { WorkflowInstance } from 'app/shared/model/workflow-instance.model';

describe('Component Tests', () => {
  describe('WorkflowInstance Management Component', () => {
    let comp: WorkflowInstanceComponent;
    let fixture: ComponentFixture<WorkflowInstanceComponent>;
    let service: WorkflowInstanceService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceComponent],
        providers: []
      })
        .overrideTemplate(WorkflowInstanceComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowInstanceComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowInstanceService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new WorkflowInstance(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.workflowInstances && comp.workflowInstances[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
