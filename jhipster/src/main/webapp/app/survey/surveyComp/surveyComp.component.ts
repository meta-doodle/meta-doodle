import {Component, OnInit} from '@angular/core';
import {SurveyService} from '../survey.service';
import {IQuestion} from 'app/shared/types/question';
import {AccountService} from 'app/core/auth/account.service';

import {ActivatedRoute, Router} from '@angular/router';
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
  emptyStep!: boolean;
  private surveyView: any;


  constructor(
    private surveyService: SurveyService,
    private accountService: AccountService,
    private workflowService : WorkflowInstanceService,
    private answerService: AnswerService,
    private router: Router,
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
    this.idUser = this.accountService.getMdlUser();
    for(let i = 0; i < this.questions!.length; i++) {
      let answer = this.buildAnswer(this.questions![i], this.surveyService.getValue(this.questions![i].title))
      this.answerService.send(answer).subscribe((res:any)=>{
        console.log(res);
        if(i === this.questions!.length -1) {
          this.result = {};
          this.demarerInstance();
        }
      });
    };
  }

  demarerInstance(): void {
    this.idWFI = this.route.snapshot.params['id'];
    this.workflowService.view(this.login, this.idWFI).subscribe(
      (res) => {
        console.log(res,'res');
        this.surveyView = res.body;
        this.questions = this.surveyView.userInteractionDTOs;
        console.log(this.questions);
        this.step = this.surveyView.stepID;
        console.log(this.step);
        this.emptyStep = this.step === 'Empty Step';
      },
    error => {
      console.log(error+" error");
    });
  }

  buildAnswer(question: IQuestion, result : string | Array<string>): Answer {
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
   return answer;
  }

}
