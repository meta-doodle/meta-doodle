import { Component, OnInit } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AccountService } from 'app/core/auth/account.service';
import {IMdlUser} from 'app/shared/model/mdl-user.model';
import {MdlUserService} from "../../entities/mdl-user/mdl-user.service";
import {User} from "../../core/user/user.model";
import { UserService } from "../../core/user/user.service";


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
              private userService: UserService,
              private mdlUserService: MdlUserService
  ) {}


  ngOnInit(): void {
    let login : string;
    let id : number;
    this.accountService.identity().subscribe( account => {
      login = account!.login;
      this.userService.find(login).subscribe( user => {
        id = user.id;
        this.mdlUserService.findUserWorkflows(id).subscribe( x => {
          x ? this.data = x.body : null;
          console.log(x, ' xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
        });
      });
    });
  }

}
