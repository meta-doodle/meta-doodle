import { Component, OnInit } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AccountService } from 'app/core/auth/account.service';
import {IMdlUser} from 'app/shared/model/mdl-user.model';
import {MdlUserService} from "../../entities/mdl-user/mdl-user.service";

@Component({
  selector: 'jhi-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})

export class ManageComponent implements OnInit {


  data: any;
  mdlUser?: IMdlUser |null;


  constructor(private workflowService: WorkflowInstanceService,
              private accountService: AccountService,
              private mdlUserService: MdlUserService,
  ) {}


  ngOnInit(): void {
    this.mdlUser = this.accountService.getMdlUser();
    this.mdlUserService.findUserWorkflows(this.mdlUser!.id!).subscribe( x => {
          x ? this.data = x.body : null;
        })
      }

}
