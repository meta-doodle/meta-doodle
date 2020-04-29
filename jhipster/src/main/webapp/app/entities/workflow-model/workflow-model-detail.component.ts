import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IWorkflowModel } from 'app/shared/model/workflow-model.model';

@Component({
  selector: 'jhi-workflow-model-detail',
  templateUrl: './workflow-model-detail.component.html'
})
export class WorkflowModelDetailComponent implements OnInit {
  workflowModel: IWorkflowModel | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowModel }) => {
      this.workflowModel = workflowModel;
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  previousState(): void {
    window.history.back();
  }
}
