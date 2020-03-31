import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICurrentStep } from 'app/shared/model/current-step.model';
import { CurrentStepService } from './current-step.service';
import { CurrentStepDeleteDialogComponent } from './current-step-delete-dialog.component';

@Component({
  selector: 'jhi-current-step',
  templateUrl: './current-step.component.html'
})
export class CurrentStepComponent implements OnInit, OnDestroy {
  currentSteps?: ICurrentStep[];
  eventSubscriber?: Subscription;

  constructor(
    protected currentStepService: CurrentStepService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.currentStepService.query().subscribe((res: HttpResponse<ICurrentStep[]>) => {
      this.currentSteps = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInCurrentSteps();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICurrentStep): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInCurrentSteps(): void {
    this.eventSubscriber = this.eventManager.subscribe('currentStepListModification', () => this.loadAll());
  }

  delete(currentStep: ICurrentStep): void {
    const modalRef = this.modalService.open(CurrentStepDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.currentStep = currentStep;
  }
}
