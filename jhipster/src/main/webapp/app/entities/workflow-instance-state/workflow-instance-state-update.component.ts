import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IWorkflowInstanceState, WorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from './workflow-instance-state.service';

@Component({
  selector: 'jhi-workflow-instance-state-update',
  templateUrl: './workflow-instance-state-update.component.html'
})
export class WorkflowInstanceStateUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: []
  });

  constructor(
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowInstanceState }) => {
      this.updateForm(workflowInstanceState);
    });
  }

  updateForm(workflowInstanceState: IWorkflowInstanceState): void {
    this.editForm.patchValue({
      id: workflowInstanceState.id
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const workflowInstanceState = this.createFromForm();
    if (workflowInstanceState.id !== undefined) {
      this.subscribeToSaveResponse(this.workflowInstanceStateService.update(workflowInstanceState));
    } else {
      this.subscribeToSaveResponse(this.workflowInstanceStateService.create(workflowInstanceState));
    }
  }

  private createFromForm(): IWorkflowInstanceState {
    return {
      ...new WorkflowInstanceState(),
      id: this.editForm.get(['id'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IWorkflowInstanceState>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
