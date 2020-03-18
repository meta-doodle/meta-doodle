import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { IStep, Step } from 'app/shared/model/step.model';
import { StepService } from './step.service';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

@Component({
  selector: 'jhi-step-update',
  templateUrl: './step-update.component.html'
})
export class StepUpdateComponent implements OnInit {
  isSaving = false;

  workflowinstances: IWorkflowInstance[] = [];
  deadlineDp: any;

  editForm = this.fb.group({
    id: [],
    mandatory: [],
    answered: [null, [Validators.required]],
    deadline: [null, [Validators.required]],
    wfInstanceId: []
  });

  constructor(
    protected stepService: StepService,
    protected workflowInstanceService: WorkflowInstanceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ step }) => {
      this.updateForm(step);

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

  updateForm(step: IStep): void {
    this.editForm.patchValue({
      id: step.id,
      mandatory: step.mandatory,
      answered: step.answered,
      deadline: step.deadline,
      wfInstanceId: step.wfInstanceId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const step = this.createFromForm();
    if (step.id !== undefined) {
      this.subscribeToSaveResponse(this.stepService.update(step));
    } else {
      this.subscribeToSaveResponse(this.stepService.create(step));
    }
  }

  private createFromForm(): IStep {
    return {
      ...new Step(),
      id: this.editForm.get(['id'])!.value,
      mandatory: this.editForm.get(['mandatory'])!.value,
      answered: this.editForm.get(['answered'])!.value,
      deadline: this.editForm.get(['deadline'])!.value,
      wfInstanceId: this.editForm.get(['wfInstanceId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStep>>): void {
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

  trackById(index: number, item: IWorkflowInstance): any {
    return item.id;
  }
}
