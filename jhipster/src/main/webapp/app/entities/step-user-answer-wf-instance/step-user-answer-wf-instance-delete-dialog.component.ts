import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { StepUserAnswerWfInstanceService } from './step-user-answer-wf-instance.service';

@Component({
  templateUrl: './step-user-answer-wf-instance-delete-dialog.component.html'
})
export class StepUserAnswerWfInstanceDeleteDialogComponent {
  stepUserAnswerWfInstance?: IStepUserAnswerWfInstance;

  constructor(
    protected stepUserAnswerWfInstanceService: StepUserAnswerWfInstanceService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.stepUserAnswerWfInstanceService.delete(id).subscribe(() => {
      this.eventManager.broadcast('stepUserAnswerWfInstanceListModification');
      this.activeModal.close();
    });
  }
}
