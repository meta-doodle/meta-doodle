import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWorkflowModel } from 'app/shared/model/workflow-model.model';

@Component({
  selector: 'jhi-workflow-model-detail',
  templateUrl: './workflow-model-detail.component.html'
})
export class WorkflowModelDetailComponent implements OnInit {
  workflowModel: IWorkflowModel | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowModel }) => {
      this.workflowModel = workflowModel;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
