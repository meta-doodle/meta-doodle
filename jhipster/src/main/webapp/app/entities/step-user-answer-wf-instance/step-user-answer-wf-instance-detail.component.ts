import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';

@Component({
  selector: 'jhi-step-user-answer-wf-instance-detail',
  templateUrl: './step-user-answer-wf-instance-detail.component.html'
})
export class StepUserAnswerWfInstanceDetailComponent implements OnInit {
  stepUserAnswerWfInstance: IStepUserAnswerWfInstance | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ stepUserAnswerWfInstance }) => {
      this.stepUserAnswerWfInstance = stepUserAnswerWfInstance;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
