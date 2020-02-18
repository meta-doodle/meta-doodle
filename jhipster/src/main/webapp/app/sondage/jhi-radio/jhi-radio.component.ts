import { Component, Input, OnInit } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'jhi-radio',
  templateUrl: 'jhi-radio.component.html',
  styleUrls: ['jhi-radio.component.scss']
})
export class JhiRadioComponent implements OnInit {
  num!: number;
  type = '';
  title!: string;
  possibleresponse!: string[];

  @Input()
  question!: {
    reponseType: string;
    commentaire: string;
    restrictions: string[];
  };
  constructor() {}

  ngOnInit(): void {
    this.type = this.question.reponseType;
    this.title = this.question.commentaire;
    this.possibleresponse = this.question.restrictions;
  }

  nextQuestion(): void {}
}
