import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { WorkflowModelService } from './workflow-model.service';

@Component({
  templateUrl: './workflow-model-delete-dialog.component.html'
})
export class WorkflowModelDeleteDialogComponent {
  workflowModel?: IWorkflowModel;

  constructor(
    protected workflowModelService: WorkflowModelService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.workflowModelService.delete(id).subscribe(() => {
      this.eventManager.broadcast('workflowModelListModification');
      this.activeModal.close();
    });
  }
}
