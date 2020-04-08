import { Component, Input, OnInit } from '@angular/core';
import { WorkflowModel } from 'app/shared/model/workflow-model.model';

@Component({
  moduleId: module.id,
  selector: 'jhi-model',
  templateUrl: 'model.component.html',
  styleUrls: ['model.component.scss']
})
export class ModelComponent implements OnInit {
  @Input() model!: WorkflowModel;

  id: number | undefined;
  title: string | undefined;
  description: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.id = this.model.id;
    this.title = this.model.title;
    this.description = this.model.description;
  }

  create(): void { }
}
