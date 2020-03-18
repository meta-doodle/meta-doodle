import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from './mdl-user.service';
import { MdlUserDeleteDialogComponent } from './mdl-user-delete-dialog.component';

@Component({
  selector: 'jhi-mdl-user',
  templateUrl: './mdl-user.component.html'
})
export class MdlUserComponent implements OnInit, OnDestroy {
  mdlUsers?: IMdlUser[];
  eventSubscriber?: Subscription;

  constructor(protected mdlUserService: MdlUserService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.mdlUserService.query().subscribe((res: HttpResponse<IMdlUser[]>) => {
      this.mdlUsers = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdlUsers();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdlUser): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdlUsers(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdlUserListModification', () => this.loadAll());
  }

  delete(mdlUser: IMdlUser): void {
    const modalRef = this.modalService.open(MdlUserDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdlUser = mdlUser;
  }
}
