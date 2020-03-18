import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IStep } from 'app/shared/model/step.model';
import { StepService } from './step.service';
import { StepDeleteDialogComponent } from './step-delete-dialog.component';

@Component({
  selector: 'jhi-step',
  templateUrl: './step.component.html'
})
export class StepComponent implements OnInit, OnDestroy {
  steps?: IStep[];
  eventSubscriber?: Subscription;

  constructor(protected stepService: StepService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.stepService.query().subscribe((res: HttpResponse<IStep[]>) => {
      this.steps = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInSteps();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IStep): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInSteps(): void {
    this.eventSubscriber = this.eventManager.subscribe('stepListModification', () => this.loadAll());
  }

  delete(step: IStep): void {
    const modalRef = this.modalService.open(StepDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.step = step;
  }
}
