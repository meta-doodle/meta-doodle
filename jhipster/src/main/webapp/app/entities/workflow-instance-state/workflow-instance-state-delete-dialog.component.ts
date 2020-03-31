import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from './workflow-instance-state.service';

@Component({
  templateUrl: './workflow-instance-state-delete-dialog.component.html'
})
export class WorkflowInstanceStateDeleteDialogComponent {
  workflowInstanceState?: IWorkflowInstanceState;

  constructor(
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.workflowInstanceStateService.delete(id).subscribe(() => {
      this.eventManager.broadcast('workflowInstanceStateListModification');
      this.activeModal.close();
    });
  }
}
