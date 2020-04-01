import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from './workflow-instance.service';

@Component({
  templateUrl: './workflow-instance-delete-dialog.component.html'
})
export class WorkflowInstanceDeleteDialogComponent {
  workflowInstance?: IWorkflowInstance;

  constructor(
    protected workflowInstanceService: WorkflowInstanceService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.workflowInstanceService.delete(id).subscribe(() => {
      this.eventManager.broadcast('workflowInstanceListModification');
      this.activeModal.close();
    });
  }
}
