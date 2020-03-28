import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { WorkflowModelComponent } from 'app/entities/workflow-model/workflow-model.component';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';
import { WorkflowModel } from 'app/shared/model/workflow-model.model';

describe('Component Tests', () => {
  describe('WorkflowModel Management Component', () => {
    let comp: WorkflowModelComponent;
    let fixture: ComponentFixture<WorkflowModelComponent>;
    let service: WorkflowModelService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowModelComponent]
      })
        .overrideTemplate(WorkflowModelComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WorkflowModelComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowModelService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new WorkflowModel(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.workflowModels && comp.workflowModels[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
