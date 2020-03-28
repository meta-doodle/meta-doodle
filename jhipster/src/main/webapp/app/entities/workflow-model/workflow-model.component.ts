import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { WorkflowModelService } from './workflow-model.service';
import { WorkflowModelDeleteDialogComponent } from './workflow-model-delete-dialog.component';

@Component({
  selector: 'jhi-workflow-model',
  templateUrl: './workflow-model.component.html'
})
export class WorkflowModelComponent implements OnInit, OnDestroy {
  workflowModels?: IWorkflowModel[];
  eventSubscriber?: Subscription;

  constructor(
    protected workflowModelService: WorkflowModelService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.workflowModelService.query().subscribe((res: HttpResponse<IWorkflowModel[]>) => (this.workflowModels = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInWorkflowModels();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IWorkflowModel): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInWorkflowModels(): void {
    this.eventSubscriber = this.eventManager.subscribe('workflowModelListModification', () => this.loadAll());
  }

  delete(workflowModel: IWorkflowModel): void {
    const modalRef = this.modalService.open(WorkflowModelDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.workflowModel = workflowModel;
  }
}
