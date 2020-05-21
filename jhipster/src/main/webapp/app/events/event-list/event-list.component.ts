import { Component, OnInit, Input } from '@angular/core';
import { AccountService } from 'app/core/auth/account.service';
import {IMdlUser} from "../../shared/model/mdl-user.model";
import {MdlUserService} from "../../entities/mdl-user/mdl-user.service";
import {IWorkflowInstance} from "../../shared/model/workflow-instance.model";

@Component({
  selector: 'jhi-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  @Input() idUser: any;
  @Input() data: IWorkflowInstance[] | undefined;
  mdlUser?: IMdlUser |null;


  constructor(private accountService: AccountService,
              private mdlUserService: MdlUserService) {
    this.remove = this.remove.bind(this);
  }

  ngOnInit(): void {
    const user =  this.accountService.getMdlUser();
    this.idUser = user ? user.userId : -1 ;
  }

  remove(index: number): void {
    if (index > -1 && this.data) {
      this.data.splice(index, 1);
    }
  }

  getStatus(index: number): number {
    if (this.data && this.data[index].creatorId === this.idUser) {
      return 1;
    } else {
      return 0;
    }
  }
}
