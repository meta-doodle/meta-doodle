import { Component, OnInit, Input } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AccountService } from 'app/core/auth/account.service';
import {WorkflowInstance} from "../../shared/model/workflow-instance.model";
import {WorkflowModelService} from "../../entities/workflow-model/workflow-model.service";
import {MdlUser} from "../../shared/model/mdl-user.model";
import {MdlUserService} from "../../entities/mdl-user/mdl-user.service";

@Component({
  selector: 'jhi-event-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.scss']
})
export class EventItemComponent implements OnInit {

  @Input() event!: WorkflowInstance;
  // @Input() event!: EventInterface;
  @Input() index!: number;
  @Input() remove!: (index: number) => void;
  @Input() owner!: number; // 1 if currentUser is owner, 0 otherwise, not boolean since it could be extended to more values


  description!: string;
  creatorLogin! : string;
  userLogin! : string;

    constructor(
    private workflowInstanceService: WorkflowInstanceService,
    private workflowModelService: WorkflowModelService,
    private accountService: AccountService,
    private mdlUserService : MdlUserService
  ) {}

  ngOnInit(): void {
      let creatorId! : number;
      this.workflowModelService.find(this.event.wfModelId!).subscribe( x => {
        x.body ? this.description = x.body.description! : "Description empty";
        x.body? creatorId = x.body.creatorId! : -1;
      });

      this.accountService.identity().subscribe( value => {
        value ?  this.userLogin = value.login : '';
      });
    }



  details(): void {
    alert('details for ' + this.event.description);
  }



  delete(): void {
    this.remove(this.index);
    this.workflowInstanceService.leave(this.userLogin, this.event.wfModelId!).subscribe( x => {
      
    });
  }

  getOwnerStatusAsString(): string {
    if (this.owner === 1) {
      return 'Organisateur';
    } else {
      return 'Participant';
    }
  }
}
