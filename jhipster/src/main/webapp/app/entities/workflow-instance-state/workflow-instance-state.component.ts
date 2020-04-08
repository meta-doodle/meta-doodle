import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from './workflow-instance-state.service';
import { WorkflowInstanceStateDeleteDialogComponent } from './workflow-instance-state-delete-dialog.component';

@Component({
  selector: 'jhi-workflow-instance-state',
  templateUrl: './workflow-instance-state.component.html'
})
export class WorkflowInstanceStateComponent implements OnInit, OnDestroy {
  workflowInstanceStates?: IWorkflowInstanceState[];
  eventSubscriber?: Subscription;

  constructor(
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.workflowInstanceStateService
      .query()
      .subscribe((res: HttpResponse<IWorkflowInstanceState[]>) => (this.workflowInstanceStates = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInWorkflowInstanceStates();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IWorkflowInstanceState): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInWorkflowInstanceStates(): void {
    this.eventSubscriber = this.eventManager.subscribe('workflowInstanceStateListModification', () => this.loadAll());
  }

  delete(workflowInstanceState: IWorkflowInstanceState): void {
    const modalRef = this.modalService.open(WorkflowInstanceStateDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.workflowInstanceState = workflowInstanceState;
  }
}
