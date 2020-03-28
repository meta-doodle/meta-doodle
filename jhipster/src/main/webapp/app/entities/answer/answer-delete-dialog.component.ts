import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAnswer } from 'app/shared/model/answer.model';
import { AnswerService } from './answer.service';

@Component({
  templateUrl: './answer-delete-dialog.component.html'
})
export class AnswerDeleteDialogComponent {
  answer?: IAnswer;

  constructor(protected answerService: AnswerService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.answerService.delete(id).subscribe(() => {
      this.eventManager.broadcast('answerListModification');
      this.activeModal.close();
    });
  }
}
