import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICurrentStep, CurrentStep } from 'app/shared/model/current-step.model';
import { CurrentStepService } from './current-step.service';
import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';

@Component({
  selector: 'jhi-current-step-update',
  templateUrl: './current-step-update.component.html'
})
export class CurrentStepUpdateComponent implements OnInit {
  isSaving = false;
  workflowinstancestates: IWorkflowInstanceState[] = [];

  editForm = this.fb.group({
    id: [],
    stepIdent: [],
    numberOfAnswer: [],
    workflowInstanceStateId: []
  });

  constructor(
    protected currentStepService: CurrentStepService,
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ currentStep }) => {
      this.updateForm(currentStep);

      this.workflowInstanceStateService
        .query()
        .subscribe((res: HttpResponse<IWorkflowInstanceState[]>) => (this.workflowinstancestates = res.body || []));
    });
  }

  updateForm(currentStep: ICurrentStep): void {
    this.editForm.patchValue({
      id: currentStep.id,
      stepIdent: currentStep.stepIdent,
      numberOfAnswer: currentStep.numberOfAnswer,
      workflowInstanceStateId: currentStep.workflowInstanceStateId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const currentStep = this.createFromForm();
    if (currentStep.id !== undefined) {
      this.subscribeToSaveResponse(this.currentStepService.update(currentStep));
    } else {
      this.subscribeToSaveResponse(this.currentStepService.create(currentStep));
    }
  }

  private createFromForm(): ICurrentStep {
    return {
      ...new CurrentStep(),
      id: this.editForm.get(['id'])!.value,
      stepIdent: this.editForm.get(['stepIdent'])!.value,
      numberOfAnswer: this.editForm.get(['numberOfAnswer'])!.value,
      workflowInstanceStateId: this.editForm.get(['workflowInstanceStateId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICurrentStep>>): void {
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

  trackById(index: number, item: IWorkflowInstanceState): any {
    return item.id;
  }
}
