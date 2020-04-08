import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowInstanceStateDetailComponent } from 'app/entities/workflow-instance-state/workflow-instance-state-detail.component';
import { WorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';

describe('Component Tests', () => {
  describe('WorkflowInstanceState Management Detail Component', () => {
    let comp: WorkflowInstanceStateDetailComponent;
    let fixture: ComponentFixture<WorkflowInstanceStateDetailComponent>;
    const route = ({ data: of({ workflowInstanceState: new WorkflowInstanceState(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceStateDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(WorkflowInstanceStateDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WorkflowInstanceStateDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load workflowInstanceState on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.workflowInstanceState).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
