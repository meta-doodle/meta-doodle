import { Component, OnInit, Input } from '@angular/core';
import { IQuestion } from 'app/shared/types/temp';
import { SurveyService } from '../survey.service';

@Component({
  selector: 'jhi-textfield',
  templateUrl: './textfield.component.html',
  styleUrls: ['./textfield.component.scss']
})
export class TextfieldComponent implements OnInit {

  @Input() question!: IQuestion

  constructor(private surveyService: SurveyService) { }

  ngOnInit(): void {
    this.surveyService.setKey(this.question.id, "")
  }

  onChange(value: string): void {
    this.surveyService.setKey(this.question.id, value)
  }

}
