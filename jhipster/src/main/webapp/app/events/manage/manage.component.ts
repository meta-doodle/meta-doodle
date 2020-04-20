import { Component, OnInit } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { WorkflowInstance, IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { AccountService } from 'app/core/auth/account.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { from } from 'rxjs';


@Component({
  selector: 'jhi-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {


  data: any | null= [];
  idUser: any | null;
  userData: any | null = [];

  datas = [
    {
      status: 'accepted',
      title: "Rétablir l'équilibre dans la Force",
      desc: 'Temps il est, jeune Padawan.',
      owner: 'user'
    },
    {
      status: 'accepted',
      title: 'Question pour un Champion',
      desc: 'Ah oui oui oui !',
      owner: 'admin'
    },
    {
      status: 'invited',
      title: 'Cueillette de champignons',
      desc: "Le saviez-tu, les champignons c'est vachement bon, viendez les jeunes, on va se régaler",
      owner: 'user'
    }
  ];


  constructor(private workflowService: WorkflowInstanceService, private userService: AccountService, private mdlUserService: MdlUserService) {}

  ngOnInit(): void {
    this.idUser = this.userService.getMdlUser();
    this.findWorkflows(this.idUser.userId);

  }

  findWorkflows(id: number):  void{
    this.mdlUserService.findUserWorkflows(id).subscribe((res)=>{
      this.data = (res.body);

    });
  }
}
