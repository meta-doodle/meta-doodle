import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRole } from 'app/shared/model/role.model';
import { RoleService } from './role.service';

@Component({
  templateUrl: './role-delete-dialog.component.html'
})
export class RoleDeleteDialogComponent {
  role?: IRole;

  constructor(protected roleService: RoleService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.roleService.delete(id).subscribe(() => {
      this.eventManager.broadcast('roleListModification');
      this.activeModal.close();
    });
  }
}
