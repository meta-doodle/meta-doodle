import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IWorkflowModel, WorkflowModel } from 'app/shared/model/workflow-model.model';
import { WorkflowModelService } from './workflow-model.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';

@Component({
  selector: 'jhi-workflow-model-update',
  templateUrl: './workflow-model-update.component.html'
})
export class WorkflowModelUpdateComponent implements OnInit {
  isSaving = false;

  mdlusers: IMdlUser[] = [];

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(25)]],
    description: [],
    body: [null, [Validators.required]],
    authorId: []
  });

  constructor(
    protected workflowModelService: WorkflowModelService,
    protected mdlUserService: MdlUserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ workflowModel }) => {
      this.updateForm(workflowModel);

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

  updateForm(workflowModel: IWorkflowModel): void {
    this.editForm.patchValue({
      id: workflowModel.id,
      title: workflowModel.title,
      description: workflowModel.description,
      body: workflowModel.body,
      authorId: workflowModel.authorId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const workflowModel = this.createFromForm();
    if (workflowModel.id !== undefined) {
      this.subscribeToSaveResponse(this.workflowModelService.update(workflowModel));
    } else {
      this.subscribeToSaveResponse(this.workflowModelService.create(workflowModel));
    }
  }

  private createFromForm(): IWorkflowModel {
    return {
      ...new WorkflowModel(),
      id: this.editForm.get(['id'])!.value,
      title: this.editForm.get(['title'])!.value,
      description: this.editForm.get(['description'])!.value,
      body: this.editForm.get(['body'])!.value,
      authorId: this.editForm.get(['authorId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IWorkflowModel>>): void {
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

  trackById(index: number, item: IMdlUser): any {
    return item.id;
  }
}
