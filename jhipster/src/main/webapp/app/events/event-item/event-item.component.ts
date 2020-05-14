import { Component, OnInit, Input } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AccountService } from 'app/core/auth/account.service';
import {WorkflowInstance} from "../../shared/model/workflow-instance.model";
import {WorkflowModelService} from "../../entities/workflow-model/workflow-model.service";
import {MdlUser} from "../../shared/model/mdl-user.model";

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
  mdlUser: MdlUser | undefined | null;
  userLogin! : String;

    constructor(
    private workflowInstanceService: WorkflowInstanceService,
    private workflowModelService: WorkflowModelService,
    private accountService: AccountService
  ) {}

  ngOnInit(): void {
      this.workflowModelService.find(this.event.wfModelId!).subscribe( x => {
        x.body ? this.description = x.body.description! : "Description empty";
      });
      this.accountService.identity().subscribe( value => {
        value ?  this.userLogin = value.login : '';
      });
      this.mdlUser  = this.accountService.getMdlUser();
    }



  details(): void {
    alert('details for ' + this.event.description);
  }

  /*
  join(): void {
    this.event.status = 'accepted';
  }
   */

  delete(): void {
    this.remove(this.index);
  }

  getOwnerStatusAsString(): string {
    if (this.owner === 1) {
      return 'Organisateur';
    } else {
      return 'Participant';
    }
  }
}
