import { Component, OnInit} from '@angular/core';
import { SurveyService } from '../survey.service';
import { IQuestion } from 'app/shared/types/question';
import { AccountService } from 'app/core/auth/account.service';

import { ActivatedRoute } from '@angular/router';
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
  answer : Answer | undefined;
  data: any ;
  questions: Array<IQuestion> | null= [];
  result:Object = {};
   id = -1;


  constructor(
    private surveyService: SurveyService,
    private accountService: AccountService,
    private workflowService : WorkflowInstanceService,
    private answerService: AnswerService,
    private route : ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.accountService.identity().subscribe( (res)=>{
      this.data = res;
      this.demarerInstance();
    })
  }

  submit(): void {
    this.result = this.surveyService.answers;
    /* debugger; */
    this.answer = {};
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
    this.workflowService.view(this.data.login, this.id).subscribe((res: any)=>{
      this.questions = res.body.questionViews ;
    })
    console.log(this.questions);

  }

  sendAnswer(answer: IAnswer): void{
    this.answerService.send(answer).subscribe((res:any)=>{
      this.questions = res.body.questionViews;
    })
  }

}
