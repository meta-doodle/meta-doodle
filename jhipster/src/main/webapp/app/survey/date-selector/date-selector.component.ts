import { Component, OnInit, Input } from '@angular/core';
import { instanceOfIDateRestriction } from 'app/shared/types/temp';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question_temp';

@Component({
  selector: 'jhi-date-selector',
  templateUrl: './date-selector.component.html',
  styleUrls: ['./date-selector.component.scss']
})
export class DateSelectorComponent implements OnInit {

  @Input()
  question!: IQuestion;

  constructor(private surveyService: SurveyService) {
  }

  ngOnInit(): void {
    this.surveyService.answers[this.question.id] = []
  }

  onChange(value: string): void {
    this.surveyService.setKey(this.question.id, value)
  }

  dateBegin(): string {
    if (instanceOfIDateRestriction(this.question.restrictions)) {
      return this.question.restrictions.dateBegin
    } else {
      return "";
    }
  }

  dateEnd(): string {
    if (instanceOfIDateRestriction(this.question.restrictions)) {
      return this.question.restrictions.dateEnd
    } else {
      return "";
    }
  }
}
