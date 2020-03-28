import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IAnswer, Answer } from 'app/shared/model/answer.model';
import { AnswerService } from './answer.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

type SelectableEntity = IMdlUser | IWorkflowInstance;

@Component({
  selector: 'jhi-answer-update',
  templateUrl: './answer-update.component.html'
})
export class AnswerUpdateComponent implements OnInit {
  isSaving = false;
  mdlusers: IMdlUser[] = [];
  workflowinstances: IWorkflowInstance[] = [];

  editForm = this.fb.group({
    id: [],
    stepIdent: [],
    questionIdent: [],
    type: [],
    answer: [],
    userId: [],
    workflowInstanceId: []
  });

  constructor(
    protected answerService: AnswerService,
    protected mdlUserService: MdlUserService,
    protected workflowInstanceService: WorkflowInstanceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ answer }) => {
      this.updateForm(answer);

      this.mdlUserService.query().subscribe((res: HttpResponse<IMdlUser[]>) => (this.mdlusers = res.body || []));

      this.workflowInstanceService.query().subscribe((res: HttpResponse<IWorkflowInstance[]>) => (this.workflowinstances = res.body || []));
    });
  }

  updateForm(answer: IAnswer): void {
    this.editForm.patchValue({
      id: answer.id,
      stepIdent: answer.stepIdent,
      questionIdent: answer.questionIdent,
      type: answer.type,
      answer: answer.answer,
      userId: answer.userId,
      workflowInstanceId: answer.workflowInstanceId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const answer = this.createFromForm();
    if (answer.id !== undefined) {
      this.subscribeToSaveResponse(this.answerService.update(answer));
    } else {
      this.subscribeToSaveResponse(this.answerService.create(answer));
    }
  }

  private createFromForm(): IAnswer {
    return {
      ...new Answer(),
      id: this.editForm.get(['id'])!.value,
      stepIdent: this.editForm.get(['stepIdent'])!.value,
      questionIdent: this.editForm.get(['questionIdent'])!.value,
      type: this.editForm.get(['type'])!.value,
      answer: this.editForm.get(['answer'])!.value,
      userId: this.editForm.get(['userId'])!.value,
      workflowInstanceId: this.editForm.get(['workflowInstanceId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAnswer>>): void {
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
