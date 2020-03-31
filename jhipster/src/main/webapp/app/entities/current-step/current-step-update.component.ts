import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { ICurrentStep, CurrentStep } from 'app/shared/model/current-step.model';
import { CurrentStepService } from './current-step.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';

type SelectableEntity = IMdlUser | IWorkflowInstanceState;

@Component({
  selector: 'jhi-current-step-update',
  templateUrl: './current-step-update.component.html'
})
export class CurrentStepUpdateComponent implements OnInit {
  isSaving = false;

  mdlusers: IMdlUser[] = [];

  workflowinstancestates: IWorkflowInstanceState[] = [];

  editForm = this.fb.group({
    id: [],
    stepIdent: [],
    numberOfAnswer: [],
    users: [],
    workflowInstanceStateId: []
  });

  constructor(
    protected currentStepService: CurrentStepService,
    protected mdlUserService: MdlUserService,
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ currentStep }) => {
      this.updateForm(currentStep);

      this.mdlUserService
        .query()
        .pipe(
          map((res: HttpResponse<IMdlUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IMdlUser[]) => (this.mdlusers = resBody));

      this.workflowInstanceStateService
        .query()
        .pipe(
          map((res: HttpResponse<IWorkflowInstanceState[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IWorkflowInstanceState[]) => (this.workflowinstancestates = resBody));
    });
  }

  updateForm(currentStep: ICurrentStep): void {
    this.editForm.patchValue({
      id: currentStep.id,
      stepIdent: currentStep.stepIdent,
      numberOfAnswer: currentStep.numberOfAnswer,
      users: currentStep.users,
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
      users: this.editForm.get(['users'])!.value,
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }

  getSelected(selectedVals: IMdlUser[], option: IMdlUser): IMdlUser {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
