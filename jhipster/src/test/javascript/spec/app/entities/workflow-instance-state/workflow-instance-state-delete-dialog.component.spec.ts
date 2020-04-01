import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MdlTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { WorkflowInstanceStateDeleteDialogComponent } from 'app/entities/workflow-instance-state/workflow-instance-state-delete-dialog.component';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';

describe('Component Tests', () => {
  describe('WorkflowInstanceState Management Delete Component', () => {
    let comp: WorkflowInstanceStateDeleteDialogComponent;
    let fixture: ComponentFixture<WorkflowInstanceStateDeleteDialogComponent>;
    let service: WorkflowInstanceStateService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [WorkflowInstanceStateDeleteDialogComponent]
      })
        .overrideTemplate(WorkflowInstanceStateDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WorkflowInstanceStateDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WorkflowInstanceStateService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
