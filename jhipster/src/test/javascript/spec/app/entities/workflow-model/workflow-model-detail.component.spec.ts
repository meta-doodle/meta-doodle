import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { MdlTestModule } from '../../../test.module';
import { WorkflowModelDetailComponent } from 'app/entities/workflow-model/workflow-model-detail.component';
import { WorkflowModel } from 'app/shared/model/workflow-model.model';

describe('Component Tests', () => {
  describe('WorkflowModel Management Detail Component', () => {
    let comp: WorkflowModelDetailComponent;
    let fixture: ComponentFixture<WorkflowModelDetailComponent>;
    let dataUtils: JhiDataUtils;
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
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load workflowModel on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.workflowModel).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });

    describe('byteSize', () => {
      it('Should call byteSize from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'byteSize');
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.byteSize(fakeBase64);

        // THEN
        expect(dataUtils.byteSize).toBeCalledWith(fakeBase64);
      });
    });

    describe('openFile', () => {
      it('Should call openFile from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'openFile');
        const fakeContentType = 'fake content type';
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.openFile(fakeContentType, fakeBase64);

        // THEN
        expect(dataUtils.openFile).toBeCalledWith(fakeContentType, fakeBase64);
      });
    });
  });
});
