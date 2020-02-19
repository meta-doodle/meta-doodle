import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {

  questions = {
    '1': {
      reponseType: 'RADIO',
      commentaire: 'Une question radio?',
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
    '2': {
      reponseType: 'CHECKBOX',
      commentaire: 'Une question checkbox?',
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
  };

  index = 0;
  type = '';
  title!: string;
  possibleresponse!: { label: string; id: string }[];

  constructor() { }

  ngOnInit(): void { }

  getCurrentQuestion(): any {
    this.index++;
    // stocker answer
    return this.questions[this.index];
  }

  getType(): string {
    return this.questions[1].reponseType;
  }
}
