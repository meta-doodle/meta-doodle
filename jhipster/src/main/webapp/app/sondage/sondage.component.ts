import { Component, OnInit } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'jhi-sondage',
  templateUrl: 'sondage.component.html',
  styleUrls: ['sondage.component.scss']
})
export class SondageComponent implements OnInit {
  questions = { Questions: [{ num: 99, type: 'checkbox', title: 'Hobbies ??', possibleresponse: ['velo', 'marche', 'DVD'] }] };

  num = -1;
  type = '';

  ngOnInit(): void {}

  getNum(): number {
    this.process();
    return this.num;
  }

  process(): void {
    this.questions.Questions.forEach(element => {
      this.num = element.num;
      this.type = element.type;
    });
  }
}
