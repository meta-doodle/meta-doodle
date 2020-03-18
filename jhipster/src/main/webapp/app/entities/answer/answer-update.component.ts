import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IAnswer, Answer } from 'app/shared/model/answer.model';
import { AnswerService } from './answer.service';
import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { StepUserAnswerWfInstanceService } from 'app/entities/step-user-answer-wf-instance/step-user-answer-wf-instance.service';

@Component({
  selector: 'jhi-answer-update',
  templateUrl: './answer-update.component.html'
})
export class AnswerUpdateComponent implements OnInit {
  isSaving = false;

  stepuseranswerwfinstances: IStepUserAnswerWfInstance[] = [];

  editForm = this.fb.group({
    id: [],
    resp: [],
    stepUserAnswerId: []
  });

  constructor(
    protected answerService: AnswerService,
    protected stepUserAnswerWfInstanceService: StepUserAnswerWfInstanceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ answer }) => {
      this.updateForm(answer);

      this.stepUserAnswerWfInstanceService
        .query()
        .pipe(
          map((res: HttpResponse<IStepUserAnswerWfInstance[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IStepUserAnswerWfInstance[]) => (this.stepuseranswerwfinstances = resBody));
    });
  }

  updateForm(answer: IAnswer): void {
    this.editForm.patchValue({
      id: answer.id,
      resp: answer.resp,
      stepUserAnswerId: answer.stepUserAnswerId
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
      resp: this.editForm.get(['resp'])!.value,
      stepUserAnswerId: this.editForm.get(['stepUserAnswerId'])!.value
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

  trackById(index: number, item: IStepUserAnswerWfInstance): any {
    return item.id;
  }
}
