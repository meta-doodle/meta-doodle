import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';

@Component({
  selector: 'jhi-workflow-instance-state-detail',
  templateUrl: './workflow-instance-state-detail.component.html'
})
export class WorkflowInstanceStateDetailComponent implements OnInit {
  workflowInstanceState: IWorkflowInstanceState | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowInstanceState }) => (this.workflowInstanceState = workflowInstanceState));
  }

  previousState(): void {
    window.history.back();
  }
}
