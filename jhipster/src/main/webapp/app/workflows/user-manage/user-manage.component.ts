import { Component, OnInit } from '@angular/core';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { AnswerService } from 'app/entities/answer/answer.service';
import { AccountService } from 'app/core/auth/account.service';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { UserManage } from 'app/shared/types/userManage';
import { RoleService } from 'app/entities/role/role.service';
import { IRole, URole, Role } from 'app/shared/model/role.model';
import { IMdlUser } from 'app/shared/model/mdl-user.model';

@Component({
  selector: 'jhi-user-manage',
  templateUrl: './user-manage.component.html',
  styleUrls: ['./user-manage.component.scss']
})

export class UserManageComponent implements OnInit {

  workflows: IWorkflowInstance[] | null = [];
  guestList: Map<any,Array<any>> = new Map();
  userIdList: Map<any,any> = new Map();
  roleListe: Array<any> = [];
  irole: Role | null = null;
  idUser: any;
  user: any;
  wfName: any;
  roleName: any;
  dataRole: any;
  role:Array<IRole> = [];
  // usermanage: UserManage  = new UserManage();
  workflowUsersList: Array<UserManage> = [];
  k = 0;
  allWorkflows: Array<IWorkflowInstance> = [];
  resultList: Array<IWorkflowInstance> = [];
  itemList: Array<any> = [];
  index: Array<any> = [];

  constructor(private mdlUserService: MdlUserService, private answerService: AnswerService,
    private userService: AccountService, private workflowInstanceService: WorkflowInstanceService,
    private roleService: RoleService ) { }

  ngOnInit() :void{


    this.idUser = this.userService.getMdlUser();



    this.workflowInstanceService.findAllInstance().subscribe((result)=>{
      this.idUser = this.userService.getMdlUser();
      this.allWorkflows = result.body? result.body: [];
      this.resultList = this.allWorkflows.filter((iter:IWorkflowInstance) =>  iter.creatorId === this.idUser.userId );

      this.resultList.forEach((elem) =>{
        this.itemList = elem.guests? elem.guests : [];
        if(this.itemList !== []){
          this.k = elem.id!;
          this.guestList.set(this.k, this.itemList);
        }
      });

      // console.log(this.guestList)

      this.guestList.forEach((values:any, keys:number) =>{
        // console.log("je passe dans "+ keys)
        // recuperation du nom du workflowInstance
        this.workflowInstanceService.findUserRole(keys).subscribe(data =>{
            this.roleListe = data.body? data.body : [];
        })

        this.workflowInstanceService.find(keys).subscribe((res)=>{
        this.wfName = res.body? res.body : null ;
        values.forEach((val:any) => {

          // console.log("je parcours "+ val.userId)
          // recuperation du role d'un user
             this.roleService.findRole(val.userId,this.wfName.id).subscribe((resultat)=>{
              this.wfName = res.body? res.body : null ;
              // console.log(this.wfName)
              this.mdlUserService.findJUser(val.userId).subscribe((data)=>{
                this.roleName = data.body
                this.dataRole = resultat.body? resultat.body : null;
                if(keys === this.wfName.id){
                  this.workflowUsersList.push(new UserManage(this.wfName.id, val.userId, this.wfName.description,this.roleName.login ,this.dataRole.role));
                }
              })

              })
          });

          })
        })


      })


    }

    distinct = (value:any,index:any,self:any) => {
      return self.indexOf(value) === index ;
   }

   updateRole(idWF: any, idUser: any, role:any): void{
     this.irole = new Role();
     this.irole.role = role ;
     this.irole.userId = idUser;
     this.irole.workflowInstanceId = idWF
     console.log(this.irole)
     this.roleService.create(this.irole).subscribe((res)=>{
       alert("insertion effectue");
     })

   }

}

