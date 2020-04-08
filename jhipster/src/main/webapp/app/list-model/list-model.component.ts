import { Component, OnInit } from '@angular/core';
import { WorkflowModelService } from '../entities/workflow-model/workflow-model.service';

@Component({
  moduleId: module.id,
  selector: 'jhi-list-model',
  templateUrl: 'list-model.component.html',
  styleUrls: ['list-model.component.scss']
})
export class ListModelComponent implements OnInit {
  models = [
    {
      id: 1,
      title: 'Soirée Pizza entre amis ',
      description: "Modele Type : Choix de date et choix d'une pizzeria"
    },
    {
      id: 2,
      title: 'La révolution type entre amis',
      description: 'Modele Type : Organisation du renversement du gouvernement'
    },
    {
      id: 3,
      title: 'Coronavirus : Qui veut des masques ? ',
      description: 'Modele Type : Organisation de la fabrication de masque et répartition des lieux de distribution'
    }
  ];

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
