import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceDetailComponent } from 'app/entities/workflow-instance/workflow-instance-detail.component';
import { WorkflowInstance } from 'app/shared/model/workflow-instance.model';

describe('Component Tests', () => {
  describe('WorkflowInstance Management Detail Component', () => {
    let comp: WorkflowInstanceDetailComponent;
    let fixture: ComponentFixture<WorkflowInstanceDetailComponent>;
    const route = ({ data: of({ workflowInstance: new WorkflowInstance(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(WorkflowInstanceDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WorkflowInstanceDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load workflowInstance on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.workflowInstance).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
