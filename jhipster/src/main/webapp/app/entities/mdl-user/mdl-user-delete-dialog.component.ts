import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from './mdl-user.service';

@Component({
  templateUrl: './mdl-user-delete-dialog.component.html'
})
export class MdlUserDeleteDialogComponent {
  mdlUser?: IMdlUser;

  constructor(protected mdlUserService: MdlUserService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdlUserService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdlUserListModification');
      this.activeModal.close();
    });
  }
}
