import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IStepUserAnswerWfInstance, StepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { StepUserAnswerWfInstanceService } from './step-user-answer-wf-instance.service';
import { IStep } from 'app/shared/model/step.model';
import { StepService } from 'app/entities/step/step.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

type SelectableEntity = IStep | IMdlUser | IWorkflowInstance;

@Component({
  selector: 'jhi-step-user-answer-wf-instance-update',
  templateUrl: './step-user-answer-wf-instance-update.component.html'
})
export class StepUserAnswerWfInstanceUpdateComponent implements OnInit {
  isSaving = false;

  steps: IStep[] = [];

  mdlusers: IMdlUser[] = [];

  workflowinstances: IWorkflowInstance[] = [];

  editForm = this.fb.group({
    id: [],
    stepId: [],
    mdlUserId: [],
    workflowInstanceId: []
  });

  constructor(
    protected stepUserAnswerWfInstanceService: StepUserAnswerWfInstanceService,
    protected stepService: StepService,
    protected mdlUserService: MdlUserService,
    protected workflowInstanceService: WorkflowInstanceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ stepUserAnswerWfInstance }) => {
      this.updateForm(stepUserAnswerWfInstance);

      this.stepService
        .query({ filter: 'stepuseranswer-is-null' })
        .pipe(
          map((res: HttpResponse<IStep[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IStep[]) => {
          if (!stepUserAnswerWfInstance.stepId) {
            this.steps = resBody;
          } else {
            this.stepService
              .find(stepUserAnswerWfInstance.stepId)
              .pipe(
                map((subRes: HttpResponse<IStep>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IStep[]) => {
                this.steps = concatRes;
              });
          }
        });

      this.mdlUserService
        .query()
        .pipe(
          map((res: HttpResponse<IMdlUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IMdlUser[]) => (this.mdlusers = resBody));

      this.workflowInstanceService
        .query()
        .pipe(
          map((res: HttpResponse<IWorkflowInstance[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IWorkflowInstance[]) => (this.workflowinstances = resBody));
    });
  }

  updateForm(stepUserAnswerWfInstance: IStepUserAnswerWfInstance): void {
    this.editForm.patchValue({
      id: stepUserAnswerWfInstance.id,
      stepId: stepUserAnswerWfInstance.stepId,
      mdlUserId: stepUserAnswerWfInstance.mdlUserId,
      workflowInstanceId: stepUserAnswerWfInstance.workflowInstanceId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const stepUserAnswerWfInstance = this.createFromForm();
    if (stepUserAnswerWfInstance.id !== undefined) {
      this.subscribeToSaveResponse(this.stepUserAnswerWfInstanceService.update(stepUserAnswerWfInstance));
    } else {
      this.subscribeToSaveResponse(this.stepUserAnswerWfInstanceService.create(stepUserAnswerWfInstance));
    }
  }

  private createFromForm(): IStepUserAnswerWfInstance {
    return {
      ...new StepUserAnswerWfInstance(),
      id: this.editForm.get(['id'])!.value,
      stepId: this.editForm.get(['stepId'])!.value,
      mdlUserId: this.editForm.get(['mdlUserId'])!.value,
      workflowInstanceId: this.editForm.get(['workflowInstanceId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStepUserAnswerWfInstance>>): void {
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
}
