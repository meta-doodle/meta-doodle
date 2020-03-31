import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICurrentStep } from 'app/shared/model/current-step.model';
import { CurrentStepService } from './current-step.service';

@Component({
  templateUrl: './current-step-delete-dialog.component.html'
})
export class CurrentStepDeleteDialogComponent {
  currentStep?: ICurrentStep;

  constructor(
    protected currentStepService: CurrentStepService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.currentStepService.delete(id).subscribe(() => {
      this.eventManager.broadcast('currentStepListModification');
      this.activeModal.close();
    });
  }
}
