import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IStep } from 'app/shared/model/step.model';
import { StepService } from './step.service';

@Component({
  templateUrl: './step-delete-dialog.component.html'
})
export class StepDeleteDialogComponent {
  step?: IStep;

  constructor(protected stepService: StepService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.stepService.delete(id).subscribe(() => {
      this.eventManager.broadcast('stepListModification');
      this.activeModal.close();
    });
  }
}
