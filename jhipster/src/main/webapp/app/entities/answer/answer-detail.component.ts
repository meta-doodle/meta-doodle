import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAnswer } from 'app/shared/model/answer.model';

@Component({
  selector: 'jhi-answer-detail',
  templateUrl: './answer-detail.component.html'
})
export class AnswerDetailComponent implements OnInit {
  answer: IAnswer | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ answer }) => (this.answer = answer));
  }

  previousState(): void {
    window.history.back();
  }
}
