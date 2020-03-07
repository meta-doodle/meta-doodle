import { Component, Input, OnInit } from '@angular/core';
import { IQuestion } from 'app/shared/types/temp';
import { SurveyService } from '../survey.service';

@Component({
  moduleId: module.id,
  selector: 'jhi-checkbox',
  templateUrl: 'jhi-checkbox.component.html',
  styleUrls: ['jhi-checkbox.component.scss']
})
export class JhiCheckboxComponent implements OnInit {

  @Input()
  question!: IQuestion;

  constructor(private surveyService: SurveyService) {
  }

  ngOnInit(): void {
    this.surveyService.answers[this.question.id] = []
  }

  onChange(value: string): void {
    const prevValue: Array<string> = this.surveyService.answers[this.question.id]
    const valIndex = prevValue.indexOf(value)

    if (valIndex === -1) {
      this.surveyService.setKey(this.question.id, [...prevValue, value])
    } else {
      prevValue.splice(valIndex, 1)
      this.surveyService.setKey(this.question.id, prevValue)
    }
  }
}