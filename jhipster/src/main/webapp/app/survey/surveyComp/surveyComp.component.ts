import { Component, OnInit, Input } from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { User } from 'app/core/user/user.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { ISurveyView } from 'app/shared/model/survey-view';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {

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

  result = {};

  constructor(private surveyService: SurveyService, private accountService: AccountService, private workflowService : WorkflowInstanceService) {}

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
  }

  demarerInstance(): void{
    this.workflowService.view(this.data.login, 1).subscribe((res: any)=>{
      this.questions = res.body.questionViews ;
    })

  }

}
