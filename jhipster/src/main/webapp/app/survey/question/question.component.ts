import { Component, OnInit, Input } from '@angular/core';
import { IQuestion } from 'app/shared/types/question_temp';

@Component({
  selector: 'jhi-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  @Input() question!: IQuestion

  constructor() { }

  ngOnInit(): void {
  }

}
