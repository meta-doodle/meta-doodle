import { Component, OnInit } from '@angular/core';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { IAnswer } from 'app/shared/model/answer.model';
import { AnswerService } from 'app/entities/answer/answer.service';
import { IModelRecap, IModelObj } from 'app/shared/types/modelRecap';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { AccountService } from 'app/core/auth/account.service';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

@Component({
  selector: 'jhi-workflow-list',
  templateUrl: './workflow-list.component.html',
  styleUrls: ['./workflow-list.component.scss']
})
export class WorkflowListComponent implements OnInit {

  workflows: IWorkflowInstance[] | null = [];
  answers: IAnswer[] | null = [];
  recapList: Array<IModelRecap> = []
  recap : IModelRecap | null = null;
  idUser: any;
  data2:any;
  mapValue: Map<number, number> = new Map();


  data = [
    {
      id: 1,
      description: "model de sondage",
      total: 17
    },
    {
      id: 2,
      description: "model de sondage pour vote",
      total: 30
    },
    {
      id: 3,
      description: "model de repartition de projet",
      total: 17
    }
  ]
  result: Array<IModelObj> = [];
  data3: any = [];
  list: Array<IModelRecap> = [];
  k: any;
  idValue: any;
  ID: any;
  item: any;
  allWorkflows: Array<IWorkflowInstance> = [];
  resultList: Array<IWorkflowInstance> = [];

  constructor(private workflowService: MdlUserService, private answerService: AnswerService,
    private userService: AccountService, private workflowInstanceService: WorkflowInstanceService ) { }

  ngOnInit() :void{

    this.idUser = this.userService.getMdlUser();

    this.workflowInstanceService.findAllInstance().subscribe((result)=>{
      this.idUser = this.userService.getMdlUser();
      this.allWorkflows = result.body? result.body: [];
      this.resultList = this.allWorkflows.filter((iter:IWorkflowInstance) =>  iter.creatorId === this.idUser.userId );
      // console.log(this.resultList);
      this.resultList.forEach( (elem:IWorkflowInstance) => {

        this.answerService.findAllAnswer().subscribe((resultat)=>{
          this.data3 =  resultat.body? resultat.body:null;
          this.data3.forEach((element:IAnswer) => {

            if(element.workflowInstanceId === elem.id)
            {
              const id = elem.id? elem.id:0 ;
            if(this.mapValue.get(id)){
              const val = this.mapValue.get(id)!;
              this.mapValue.set(id, val+1)
            }else{
              this.mapValue.set(id,1);
              const imodel = new IModelRecap(elem.id, elem.description);
              this.result.push(imodel) ;
            }
            }
          })


          this.result.forEach((value:IModelObj) =>{
             this.idValue = value.id? value.id : 0;
            this.ID = this.mapValue.get(this.idValue)!;
            this.item = new IModelRecap(value.id,value.description,this.ID);

             this.k = this.list.filter((data)=> data.id === value.id)
           if(this.k.length === 0){
              this.list.push(this.item);
            }

          })
        })

        });
    })


  }



}
