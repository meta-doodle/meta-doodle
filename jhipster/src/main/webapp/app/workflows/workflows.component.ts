import { Component, OnInit } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AnswerService } from 'app/entities/answer/answer.service';
import { Observable } from 'rxjs';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { IAnswer } from 'app/shared/model/answer.model';

@Component({
  selector: 'jhi-workflows',
  templateUrl: './workflows.component.html',
  styleUrls: ['./workflows.component.scss']
})
export class WorkflowsComponent implements OnInit {

  workflows: IWorkflowInstance[] | null = [];
  instance: IAnswer[] | null = [];

  constructor(private workflowService: WorkflowInstanceService, private answerService: AnswerService) { }

  ngOnInit() :void{
    this.findAllWorkflows();
    this.findAllanswers();
  }

  findAllWorkflows(): void{
    this.workflowService.findAllInstance().subscribe((res)=>{
      this.workflows = res.body;
      console.log(this.workflows);
    })
  }

  findAllanswers(): void {
    this.answerService.findAllAnswer().subscribe((res)=>{
      this.instance = res.body;
      console.log(this.instance);
    })
  }

}
