import { Component, OnInit } from '@angular/core';
import { IQuestion } from '../../shared/types/temp'

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {

  questions: Array<IQuestion> = [{
    answerType: 'RADIO',
    title: 'Une question radio?',
    restrictions: [
      {
        label: 'Votre choix numéro un',
        id: 'choix1'
      },
      {
        label: 'Choix numéro 2',
        id: 'choix2'
      }
    ]
  },
  {
    answerType: 'CHECKBOX',
    title: 'Une question checkbox?',
    restrictions: [
      {
        label: 'Votre choix numéro un',
        id: 'choix1'
      },
      {
        label: 'Choix numéro 2',
        id: 'choix2'
      }
    ]
  }
  ];

  index = 0;

  constructor() { }

  ngOnInit(): void { }

  getCurrentQuestion(): IQuestion {
    return this.questions[this.index];
  }

  incrQuestionIndex(): void {
    this.index++
  }

  getType(): string {
    return this.questions[this.index].answerType;
  }
}
