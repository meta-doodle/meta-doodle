import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'jhi-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  @Input() data: Array<EventInterface> = []

  constructor() {
    this.remove = this.remove.bind(this);
  }

  ngOnInit(): void {
  }

  remove(index: number): void {
    if (index > -1) {
      this.data.splice(index, 1);
    }
  }

}
