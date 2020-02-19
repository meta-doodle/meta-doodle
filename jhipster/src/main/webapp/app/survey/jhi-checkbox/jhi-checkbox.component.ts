import { Component, Input, OnInit } from '@angular/core';
import { IQuestion } from 'app/shared/types/temp';

@Component({
  moduleId: module.id,
  selector: 'jhi-checkbox',
  templateUrl: 'jhi-checkbox.component.html',
  styleUrls: ['jhi-checkbox.component.scss']
})
export class JhiCheckboxComponent implements OnInit {

  @Input()
  question!: IQuestion;
  constructor() { }

  ngOnInit(): void {
  }
}
