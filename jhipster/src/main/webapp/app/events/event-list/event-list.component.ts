import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'app/core/user/user.service';
import { User } from 'app/core/user/user.model';
import { AccountService } from 'app/core/auth/account.service';

@Component({
  selector: 'jhi-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {
  @Input() data: Array<EventInterface> = [];
  currentUser!: User;

  constructor(private accountService: AccountService, private userService: UserService) {
    this.remove = this.remove.bind(this);
  }

  ngOnInit(): void {
    this.accountService.identity().subscribe(account => {
      if (account) {
        this.userService.find(account.login).subscribe(user => {
          this.currentUser = user;
        });
      }
    });
  }

  remove(index: number): void {
    if (index > -1) {
      this.data.splice(index, 1);
    }
  }

  getStatus(index: number): number {
    if (this.data[index].owner === this.currentUser.login) {
      return 1;
    } else {
      return 0;
    }
  }
}
