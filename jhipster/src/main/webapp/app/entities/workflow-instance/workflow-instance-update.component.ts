import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IWorkflowInstance, WorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from './workflow-instance.service';
import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from 'app/entities/workflow-instance-state/workflow-instance-state.service';
import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';

type SelectableEntity = IWorkflowInstanceState | IWorkflowModel | IMdlUser;

@Component({
  selector: 'jhi-workflow-instance-update',
  templateUrl: './workflow-instance-update.component.html'
})
export class WorkflowInstanceUpdateComponent implements OnInit {
  isSaving = false;

  states: IWorkflowInstanceState[] = [];

  workflowmodels: IWorkflowModel[] = [];

  mdlusers: IMdlUser[] = [];

  editForm = this.fb.group({
    id: [],
    description: [],
    stateId: [],
    wfModelId: [],
    guests: [],
    creatorId: []
  });

  constructor(
    protected workflowInstanceService: WorkflowInstanceService,
    protected workflowInstanceStateService: WorkflowInstanceStateService,
    protected workflowModelService: WorkflowModelService,
    protected mdlUserService: MdlUserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowInstance }) => {
      this.updateForm(workflowInstance);

      this.workflowInstanceStateService
        .query({ filter: 'workflowinstance-is-null' })
        .pipe(
          map((res: HttpResponse<IWorkflowInstanceState[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IWorkflowInstanceState[]) => {
          if (!workflowInstance.stateId) {
            this.states = resBody;
          } else {
            this.workflowInstanceStateService
              .find(workflowInstance.stateId)
              .pipe(
                map((subRes: HttpResponse<IWorkflowInstanceState>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IWorkflowInstanceState[]) => {
                this.states = concatRes;
              });
          }
        });

      this.workflowModelService
        .query()
        .pipe(
          map((res: HttpResponse<IWorkflowModel[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IWorkflowModel[]) => (this.workflowmodels = resBody));

      this.mdlUserService
        .query()
        .pipe(
          map((res: HttpResponse<IMdlUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IMdlUser[]) => (this.mdlusers = resBody));
    });
  }

  updateForm(workflowInstance: IWorkflowInstance): void {
    this.editForm.patchValue({
      id: workflowInstance.id,
      description: workflowInstance.description,
      stateId: workflowInstance.stateId,
      wfModelId: workflowInstance.wfModelId,
      guests: workflowInstance.guests,
      creatorId: workflowInstance.creatorId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const workflowInstance = this.createFromForm();
    if (workflowInstance.id !== undefined) {
      this.subscribeToSaveResponse(this.workflowInstanceService.update(workflowInstance));
    } else {
      this.subscribeToSaveResponse(this.workflowInstanceService.create(workflowInstance));
    }
  }

  private createFromForm(): IWorkflowInstance {
    return {
      ...new WorkflowInstance(),
      id: this.editForm.get(['id'])!.value,
      description: this.editForm.get(['description'])!.value,
      stateId: this.editForm.get(['stateId'])!.value,
      wfModelId: this.editForm.get(['wfModelId'])!.value,
      guests: this.editForm.get(['guests'])!.value,
      creatorId: this.editForm.get(['creatorId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IWorkflowInstance>>): void {
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
