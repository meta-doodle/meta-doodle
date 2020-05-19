import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IRole, Role } from 'app/shared/model/role.model';
import { RoleService } from './role.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';

type SelectableEntity = IMdlUser | IWorkflowInstance;

@Component({
  selector: 'jhi-role-update',
  templateUrl: './role-update.component.html'
})
export class RoleUpdateComponent implements OnInit {
  isSaving = false;

  mdlusers: IMdlUser[] = [];

  workflowinstances: IWorkflowInstance[] = [];

  editForm = this.fb.group({
    id: [],
    role: [],
    userId: [],
    workflowInstanceId: []
  });

  constructor(
    protected roleService: RoleService,
    protected mdlUserService: MdlUserService,
    protected workflowInstanceService: WorkflowInstanceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ role }) => {
      this.updateForm(role);

      this.mdlUserService
        .query()
        .pipe(
          map((res: HttpResponse<IMdlUser[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IMdlUser[]) => (this.mdlusers = resBody));

      this.workflowInstanceService
        .query()
        .pipe(
          map((res: HttpResponse<IWorkflowInstance[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IWorkflowInstance[]) => (this.workflowinstances = resBody));
    });
  }

  updateForm(role: IRole): void {
    this.editForm.patchValue({
      id: role.id,
      role: role.role,
      userId: role.userId,
      workflowInstanceId: role.workflowInstanceId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const role = this.createFromForm();
    if (role.id !== undefined) {
      this.subscribeToSaveResponse(this.roleService.update(role));
    } else {
      this.subscribeToSaveResponse(this.roleService.create(role));
    }
  }

  private createFromForm(): IRole {
    return {
      ...new Role(),
      id: this.editForm.get(['id'])!.value,
      role: this.editForm.get(['role'])!.value,
      userId: this.editForm.get(['userId'])!.value,
      workflowInstanceId: this.editForm.get(['workflowInstanceId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IRole>>): void {
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
