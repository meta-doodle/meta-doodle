import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from './workflow-instance.service';
import { WorkflowInstanceDeleteDialogComponent } from './workflow-instance-delete-dialog.component';

@Component({
  selector: 'jhi-workflow-instance',
  templateUrl: './workflow-instance.component.html'
})
export class WorkflowInstanceComponent implements OnInit, OnDestroy {
  workflowInstances?: IWorkflowInstance[];
  eventSubscriber?: Subscription;

  constructor(
    protected workflowInstanceService: WorkflowInstanceService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.workflowInstanceService.query().subscribe((res: HttpResponse<IWorkflowInstance[]>) => {
      this.workflowInstances = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInWorkflowInstances();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IWorkflowInstance): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInWorkflowInstances(): void {
    this.eventSubscriber = this.eventManager.subscribe('workflowInstanceListModification', () => this.loadAll());
  }

  delete(workflowInstance: IWorkflowInstance): void {
    const modalRef = this.modalService.open(WorkflowInstanceDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.workflowInstance = workflowInstance;
  }
}
