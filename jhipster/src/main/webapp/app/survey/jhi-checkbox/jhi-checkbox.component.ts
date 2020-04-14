import { Component, Input, OnInit } from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';

@Component({
  moduleId: module.id,
  selector: 'jhi-checkbox',
  templateUrl: 'jhi-checkbox.component.html',
  styleUrls: ['jhi-checkbox.component.scss']
})
export class JhiCheckboxComponent implements OnInit {
  @Input()
  question!: IQuestion;

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {
    this.surveyService.answers[this.question.intitule] = [];
  }

  onChange(value: string): void {
    const prevValue: Array<string> = this.surveyService.answers[this.question.intitule];
    const valIndex = prevValue.indexOf(value);

    if (valIndex === -1) {
      this.surveyService.setKey(this.question.intitule, [...prevValue, value]);
    } else {
      prevValue.splice(valIndex, 1);
      this.surveyService.setKey(this.question.intitule, prevValue);
    }
  }
}
