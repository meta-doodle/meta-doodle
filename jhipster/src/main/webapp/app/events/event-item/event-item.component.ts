import { Component, OnInit, Input } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';

@Component({
  selector: 'jhi-event-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.scss']
})
export class EventItemComponent implements OnInit {
  @Input() event!: EventInterface;
  @Input() index!: number;
  @Input() remove!: (index: number) => void;
  @Input() ownerStatus!: number; // 1 if currentUser is owner, 0 otherwise, not boolean since it could be extended to more values

  userLogin: any;

  constructor(private workflowInstanceService: WorkflowInstanceService, private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountService.identity().subscribe( (res: any)=>{
      this.userLogin = res.login;
    })
  }

  details(): void {
    alert('details for ' + this.event.title);
  }

  join(): void {
    this.event.status = 'accepted';
  }

  delete(): void {
    this.remove(this.index);
  }

  getOwnerStatusAsString(): string {
    if (this.ownerStatus === 1) {
      return 'Organisateur';
    } else {
      return 'Participant';
    }
  }
}
