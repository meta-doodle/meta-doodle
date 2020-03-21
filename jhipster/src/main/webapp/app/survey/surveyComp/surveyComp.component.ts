import { Component, OnInit } from '@angular/core';
import { IQuestion } from '../../shared/types/temp';
import { SurveyService } from '../survey.service';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {
  questions: Array<IQuestion> = [
    {
      answerType: 'RADIO',
      title: 'A La vie, dans son sens intemporel, universel et grandiloquent, a-t-elle une once de sens ?',
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
    }
  ];

  result = {};

  constructor(private surveyService: SurveyService) {}

  ngOnInit(): void {}

  submit(): void {
    this.result = this.surveyService.answers;
    /* debugger; */

    this.result = this.surveyService.answers

  }
}
