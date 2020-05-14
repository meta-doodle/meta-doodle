import { Component, OnInit, Input } from '@angular/core';
import { instanceOfIDateRestriction } from 'app/shared/types/options';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';

@Component({
  selector: 'jhi-date-selector',
  templateUrl: './date-selector.component.html',
  styleUrls: ['./date-selector.component.scss']
})
export class DateSelectorComponent implements OnInit {
  @Input()
  question!: IQuestion;

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {
    this.surveyService.answers[this.question.questionId] = [];
  }

  onChange(value: string): void {
    this.surveyService.setKey(this.question.questionId, value);
  }

  dateBegin(): string {
    /*
    if (instanceOfIDateRestriction(this.question.options.get())) {
      return this.question.options.get('dateBegin');
    } else {
      return '';
    }

     */
    const dateBegin = this.question.options.get('dateBegin');
    if ( dateBegin != null && dateBegin) {
      return dateBegin;
  } else {
     return '';
}
  }

  dateEnd(): string {
    /*
    if (instanceOfIDateRestriction(this.question.restrictions)) {
      return this.question.restrictions.dateEnd;
    } else {
      return '';
    }*/
    let dateEnd = this.question.options.get('dateEnd');
    if ( dateEnd != null && dateEnd) {
      return dateEnd;
    } else {
      return '';
    }
  }
}
