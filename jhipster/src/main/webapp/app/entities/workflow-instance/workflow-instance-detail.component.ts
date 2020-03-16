import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';

@Component({
  selector: 'jhi-workflow-instance-detail',
  templateUrl: './workflow-instance-detail.component.html'
})
export class WorkflowInstanceDetailComponent implements OnInit {
  workflowInstance: IWorkflowInstance | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowInstance }) => {
      this.workflowInstance = workflowInstance;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
