import { Component, OnInit} from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';
import { AccountService } from 'app/core/auth/account.service';

import { IAnswer, Answer } from 'app/shared/model/answer.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

import { AnswerService } from 'app/entities/answer/answer.service';

import { AvailableTypes } from 'app/shared/model/enumerations/available-types.model';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {

  compteur = 0;
  idUser : any | null;
  answer = new Answer;
   data: any ;
   questions: Array<IQuestion> | null= [];
  questionsU: Array<IQuestion> = [
    {
      reponseType: 'RADIO',
      intitule: 'La vie, dans son sens intemporel, universel et grandiloquent, a-t-elle une once de sens ?',
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
      reponseType: 'CHECKBOX',
      intitule: 'Ils sont où les quignons à Kadoc ?',
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
      reponseType: 'TEXTFIELD',
      intitule: 'Quel est la différence entre un hamburger ?',
      id: 'hamburger',
      restrictions: []
    },
    {
      reponseType: 'DATE',
      intitule: 'Si la mémoire est à la tête ce que le passé, peut-on y accéder à six ?',
      id: 'memoire',
      restrictions: {
        dateBegin: '2020-03-09',
        dateEnd: '2020-05-15'
      }
    }
  ];

  result:Object = {};


  constructor(private surveyService: SurveyService, private accountService: AccountService,
    private workflowService : WorkflowInstanceService, private answerService: AnswerService) {}

  ngOnInit(): void {
    this.accountService.identity().subscribe( (res)=>{
      this.data = res;
      this.demarerInstance();
    })
  }

  submit(): void {
    this.result = this.surveyService.answers;
    /* debugger; */

    this.result = this.surveyService.answers;
    this.idUser = this.accountService.getMdlUser();

    this.compteur = 0;
    if(this.result !=="{}"){

      for(const elem in this.result){

        if ({}.hasOwnProperty.call(this.result, elem)) {

          this.answer.answer = "oui";
          this.answer.questionIdent = "0";
          this.answer.stepIdent = "0";
          this.answer.type = AvailableTypes.String;
          this.answer.userId = this.idUser.userId;
          this.answer.workflowInstanceId = 2;
          this.compteur = this.compteur + 1;
          this.sendAnswer(this.answer);
      }
    }

    this.result = new Object;
    }
  }

  demarerInstance(): void{
    this.workflowService.view(this.data.login, 2).subscribe((res: any)=>{
      this.questions = res.body.questionViews ;
    })

  }

  sendAnswer(answer: IAnswer): void{
    this.answerService.send(answer).subscribe((res:any)=>{
      this.questions = res.body.questionViews;
    })
  }

}
