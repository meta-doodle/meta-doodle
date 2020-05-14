import {Component, OnInit} from '@angular/core';
import {SurveyService} from '../survey.service';
import {IQuestion} from 'app/shared/types/question';
import {AccountService} from 'app/core/auth/account.service';

import {ActivatedRoute} from '@angular/router';
import {Answer} from 'app/shared/model/answer.model';
import {WorkflowInstanceService} from 'app/entities/workflow-instance/workflow-instance.service';

import {AnswerService} from 'app/entities/answer/answer.service';
import {AvailableTypes} from "../../shared/model/enumerations/available-types.model";

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})

export class SurveyComponent implements OnInit {

  idUser : any | null;
  data: any ;
  questions: IQuestion[] | undefined;
  result:Object = {};
  idWFI = -1;
  step! : string;
  login!: string;
  private surveyView: any;


  constructor(
    private surveyService: SurveyService,
    private accountService: AccountService,
    private workflowService : WorkflowInstanceService,
    private answerService: AnswerService,
    private route : ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.idWFI = this.route.snapshot.params['id'];
    this.accountService.identity().subscribe( (res)=>{
      this.data = res;
      this.login = this.data.login;
      this.demarerInstance();
    });
  }

  submit(): void {
    this.result = this.surveyService.answers;
    console.log(this.result,'result');
    this.idUser = this.accountService.getMdlUser();
    this.questions!.forEach(question => this.sendAnswer(question, this.surveyService.getValue(question.title))
    );
  }

  demarerInstance(): void {
    this.workflowService.view(this.login, this.idWFI).subscribe(
      (res) => {
        this.surveyView = res.body;
        this.questions = this.surveyView.userInteractionDTOs;
        this.step = this.surveyView.stepID;
        console.log(this.surveyView, 'survey');
      },
    error => {
      console.log(error+" error");
    });
  }

  sendAnswer(question: IQuestion, result : string | Array<string>): void{
    const answer : Answer = {};
    if(Array.isArray(result)) {
      result = result.join();
    }
    answer.answer = result;
    answer.questionIdent = question.questionID;
    answer.stepIdent = this.step;
    if( question.questionType === AvailableTypes.Date) {
      answer.type = AvailableTypes.Date;
    } else {
      answer.type = AvailableTypes.String;
    }
    answer.userId = this.idUser.userId;
    answer.workflowInstanceId = this.idWFI;
    this.answerService.send(answer).subscribe((res:any)=>{
     //this.questions = res.body.questionViews;
    });
    console.log(answer, 'answer');
  }

}
