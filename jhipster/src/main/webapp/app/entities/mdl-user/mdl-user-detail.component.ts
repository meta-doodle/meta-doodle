import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdlUser } from 'app/shared/model/mdl-user.model';

@Component({
  selector: 'jhi-mdl-user-detail',
  templateUrl: './mdl-user-detail.component.html'
})
export class MdlUserDetailComponent implements OnInit {
  mdlUser: IMdlUser | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdlUser }) => {
      this.mdlUser = mdlUser;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
