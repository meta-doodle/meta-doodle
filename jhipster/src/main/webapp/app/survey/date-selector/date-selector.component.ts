import { Component, OnInit, Input } from '@angular/core';
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
  begin! : string;
  end! : string;
  title!: string;

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {
    // console.log(this.question, 'question');
    this.surveyService.answers[this.question.questionID] = [];
    if(this.question) {
      this.title = this.question.title;
      this.begin = this.reformatDate(this.question.options.dateBegin);
      this.end = this.reformatDate(this.question.options.dateEnd);
    } else {
      // console.log("error qie")
    }
  }

  reformatDate(date : string) : string {
    let split : Array<String>;
    let result = '';
    if(date && date != null) {
      split = date.split("/");
      if(split.length === 3) {
        split.reverse();
        result = split.join("-");
      }
    }
    // console.log(result, 'date format')
    return result;
  }

  onChange(value: string): void {
    this.surveyService.setKey(this.question.questionID, value);
  }
}
