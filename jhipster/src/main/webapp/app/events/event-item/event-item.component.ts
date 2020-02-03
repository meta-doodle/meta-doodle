import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'jhi-event-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.scss']
})
export class EventItemComponent implements OnInit {

  @Input() event!: EventInterface;
  @Input() index!: number
  @Input() remove!: (index: number) => void

  constructor() { }

  ngOnInit(): void {
  }

  details(): void {
    alert("details for " + this.event.title)
  }

  join(): void {
    this.event.status = "accepted"
  }

  delete(): void {
    this.remove(this.index);
  }

}
