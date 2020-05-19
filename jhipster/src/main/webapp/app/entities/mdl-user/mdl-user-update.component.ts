import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IMdlUser, MdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from './mdl-user.service';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';
import { IRole } from 'app/shared/model/role.model';
import { RoleService } from 'app/entities/role/role.service';

type SelectableEntity = IUser | IRole;

@Component({
  selector: 'jhi-mdl-user-update',
  templateUrl: './mdl-user-update.component.html'
})
export class MdlUserUpdateComponent implements OnInit {
  isSaving = false;

  users: IUser[] = [];

  roles: IRole[] = [];

  editForm = this.fb.group({
    id: [],
    userId: [],
    roleId: []
  });

  constructor(
    protected mdlUserService: MdlUserService,
    protected userService: UserService,
    protected roleService: RoleService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdlUser }) => {
      this.updateForm(mdlUser);

      this.userService
        .query()
        .pipe(
          map((res: HttpResponse<IUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IUser[]) => (this.users = resBody));

      this.roleService
        .query()
        .pipe(
          map((res: HttpResponse<IRole[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IRole[]) => (this.roles = resBody));
    });
  }

  updateForm(mdlUser: IMdlUser): void {
    this.editForm.patchValue({
      id: mdlUser.id,
      userId: mdlUser.userId,
      roleId: mdlUser.roleId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const mdlUser = this.createFromForm();
    if (mdlUser.id !== undefined) {
      this.subscribeToSaveResponse(this.mdlUserService.update(mdlUser));
    } else {
      this.subscribeToSaveResponse(this.mdlUserService.create(mdlUser));
    }
  }

  private createFromForm(): IMdlUser {
    return {
      ...new MdlUser(),
      id: this.editForm.get(['id'])!.value,
      userId: this.editForm.get(['userId'])!.value,
      roleId: this.editForm.get(['roleId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMdlUser>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
