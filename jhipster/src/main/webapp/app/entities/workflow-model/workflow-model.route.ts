import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IWorkflowModel, WorkflowModel } from 'app/shared/model/workflow-model.model';
import { WorkflowModelService } from './workflow-model.service';
import { WorkflowModelComponent } from './workflow-model.component';
import { WorkflowModelDetailComponent } from './workflow-model-detail.component';
import { WorkflowModelUpdateComponent } from './workflow-model-update.component';

@Injectable({ providedIn: 'root' })
export class WorkflowModelResolve implements Resolve<IWorkflowModel> {
  constructor(private service: WorkflowModelService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IWorkflowModel> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((workflowModel: HttpResponse<WorkflowModel>) => {
          if (workflowModel.body) {
            return of(workflowModel.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new WorkflowModel());
  }
}

export const workflowModelRoute: Routes = [
  {
    path: '',
    component: WorkflowModelComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowModels'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: WorkflowModelDetailComponent,
    resolve: {
      workflowModel: WorkflowModelResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowModels'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: WorkflowModelUpdateComponent,
    resolve: {
      workflowModel: WorkflowModelResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowModels'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: WorkflowModelUpdateComponent,
    resolve: {
      workflowModel: WorkflowModelResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowModels'
    },
    canActivate: [UserRouteAccessService]
  }
];
