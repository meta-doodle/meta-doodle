import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { StepUserAnswerWfInstanceService } from './step-user-answer-wf-instance.service';
import { StepUserAnswerWfInstanceDeleteDialogComponent } from './step-user-answer-wf-instance-delete-dialog.component';

@Component({
  selector: 'jhi-step-user-answer-wf-instance',
  templateUrl: './step-user-answer-wf-instance.component.html'
})
export class StepUserAnswerWfInstanceComponent implements OnInit, OnDestroy {
  stepUserAnswerWfInstances?: IStepUserAnswerWfInstance[];
  eventSubscriber?: Subscription;

  constructor(
    protected stepUserAnswerWfInstanceService: StepUserAnswerWfInstanceService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.stepUserAnswerWfInstanceService.query().subscribe((res: HttpResponse<IStepUserAnswerWfInstance[]>) => {
      this.stepUserAnswerWfInstances = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInStepUserAnswerWfInstances();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IStepUserAnswerWfInstance): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInStepUserAnswerWfInstances(): void {
    this.eventSubscriber = this.eventManager.subscribe('stepUserAnswerWfInstanceListModification', () => this.loadAll());
  }

  delete(stepUserAnswerWfInstance: IStepUserAnswerWfInstance): void {
    const modalRef = this.modalService.open(StepUserAnswerWfInstanceDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.stepUserAnswerWfInstance = stepUserAnswerWfInstance;
  }
}
