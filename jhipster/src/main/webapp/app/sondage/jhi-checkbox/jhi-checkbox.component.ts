import { Component, Input, OnInit } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'jhi-checkbox',
  templateUrl: 'jhi-checkbox.component.html',
  styleUrls: ['jhi-checkbox.component.scss']
})
export class JhiCheckboxComponent implements OnInit {
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
}
