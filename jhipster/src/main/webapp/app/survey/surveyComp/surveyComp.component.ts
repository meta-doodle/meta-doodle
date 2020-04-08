import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {
  questions: Array<IQuestion> = [
    {
      answerType: 'RADIO',
      title: 'La vie, dans son sens intemporel, universel et grandiloquent, a-t-elle une once de sens ?',
      id: 'vie',
      restrictions: [
        {
          label: 'Café',
          id: 'vie-cafe'
        },
        {
          label: 'UwU',
          id: 'vie-uwu'
        }
      ]
    },
    {
      answerType: 'CHECKBOX',
      title: 'Ils sont où les quignons à Kadoc ?',
      id: 'quignons',
      restrictions: [
        {
          label: 'Ils sont bien cachés',
          id: 'quignons-caches'
        },
        {
          label: 'Ils sont dans la poche',
          id: 'quignons-poche'
        },
        {
          label: "Bon allez on part ? Parce que Kadoc i' doit suivre",
          id: 'quignons-part'
        }
      ]
    },
    {
      answerType: 'TEXTFIELD',
      title: 'Quel est la différence entre un hamburger ?',
      id: 'hamburger',
      restrictions: []
    },
    {
      answerType: 'DATE',
      title: 'Si la mémoire est à la tête ce que le passé, peut-on y accéder à six ?',
      id: 'memoire',
      restrictions: {
        dateBegin: '2020-03-09',
        dateEnd: '2020-05-15'
      }
    }
  ];

  result = {};

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {

  }

  submit(): void {
    this.result = this.surveyService.answers;
    /* debugger; */

    this.result = this.surveyService.answers;
  }
}
