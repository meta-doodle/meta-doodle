import { Component, OnInit } from '@angular/core';
import { WorkflowModelService } from '../entities/workflow-model/workflow-model.service';

@Component({
  moduleId: module.id,
  selector: 'jhi-list-model',
  templateUrl: 'list-model.component.html',
  styleUrls: ['list-model.component.scss']
})
export class ListModelComponent implements OnInit {
  modelsType: any;

  constructor(private service: WorkflowModelService) {}

  loadAll(): void {
    this.service.findAll().subscribe(data => {
      this.modelsType = data.body ? data.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
  }
}
