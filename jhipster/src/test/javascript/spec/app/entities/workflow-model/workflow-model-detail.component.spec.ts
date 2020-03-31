import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { WorkflowModelDetailComponent } from 'app/entities/workflow-model/workflow-model-detail.component';
import { WorkflowModel } from 'app/shared/model/workflow-model.model';

describe('Component Tests', () => {
  describe('WorkflowModel Management Detail Component', () => {
    let comp: WorkflowModelDetailComponent;
    let fixture: ComponentFixture<WorkflowModelDetailComponent>;
    const route = ({ data: of({ workflowModel: new WorkflowModel(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowModelDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(WorkflowModelDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WorkflowModelDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load workflowModel on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.workflowModel).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
