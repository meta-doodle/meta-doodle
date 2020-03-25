import { Component, Input, OnInit } from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';

@Component({
  moduleId: module.id,
  selector: 'jhi-radio',
  templateUrl: 'jhi-radio.component.html',
  styleUrls: ['jhi-radio.component.scss']
})
export class JhiRadioComponent implements OnInit {
  @Input() question!: IQuestion;

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {
    this.surveyService.setKey(this.question.id, '');
  }

  onChange(value: string): void {
    this.surveyService.setKey(this.question.id, value);
  }
}
