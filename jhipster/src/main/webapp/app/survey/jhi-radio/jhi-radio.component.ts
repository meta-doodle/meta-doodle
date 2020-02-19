import { Component, Input, OnInit } from '@angular/core';
import { IQuestion } from 'app/shared/types/temp';

@Component({
  moduleId: module.id,
  selector: 'jhi-radio',
  templateUrl: 'jhi-radio.component.html',
  styleUrls: ['jhi-radio.component.scss']
})
export class JhiRadioComponent implements OnInit {

  @Input()
  question!: IQuestion;
  constructor() { }

  ngOnInit(): void {
  }

  nextQuestion(): void { }
}
