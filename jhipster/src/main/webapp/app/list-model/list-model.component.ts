import { Component, OnInit } from '@angular/core';

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

  constructor() {}

  ngOnInit(): void {}
}
