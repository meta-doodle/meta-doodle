import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AnswerService } from 'app/entities/answer/answer.service';
import { IAnswer } from 'app/shared/model/answer.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

@Component({
  selector: 'jhi-workflow-details',
  templateUrl: './workflow-details.component.html',
  styleUrls: ['./workflow-details.component.scss']
})
export class WorkflowDetailsComponent implements OnInit {

  data =
    {
      id: 1,
      description: "model de sondage",
      total: 17
    }
  wId: any;
  iter!: number;
  iter2!: number;
  answerList: Array<IAnswer> = [];
  answers: Array<IAnswer> = [];
  workflow : any;


  constructor(private route: ActivatedRoute, private answerService: AnswerService, private workflowService: WorkflowInstanceService) { }

  ngOnInit(): void{
    this.wId = this.route.snapshot.paramMap.get('id');
    this.iter2 = parseInt(this.wId, 16);
    this.workflowService.find(this.iter2).subscribe((res)=> {
      this.workflow = res.body;
    });

    this.answerService.findAllAnswer().subscribe((res)=>{
      this.wId = this.route.snapshot.paramMap.get('id');
        this.answerList = res.body? res.body : [];
         // console.log(this.answerList);
         // console.log(this.wId)
         this.iter = parseInt(this.wId, 16)
        this.answers = this.answerList.filter( data => {
          return data.workflowInstanceId ===  this.iter;
        })
        // console.log(this.answers);
    })

  }

}
