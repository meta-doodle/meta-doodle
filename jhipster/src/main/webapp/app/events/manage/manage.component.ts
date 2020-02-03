import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})

export class ManageComponent implements OnInit {

  data = [
    {
      status: "accepted",
      title: "Rétablir l'équilibre dans la Force",
      desc: "Temps il est, jeune Padawan.",
      owner: "Maître Yoda"
    },
    {
      status: "accepted",
      title: "Question pour un Champion",
      desc: "Ah oui oui oui !",
      owner: "Julien Lepers"
    },
    {
      status: "invited",
      title: "Cueillette de champignons",
      desc: "Le saviez-tu, les champignons c'est vachement bon, viendez les jeunes, on va se régaler",
      owner: "Mamie Molette"
    }
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
