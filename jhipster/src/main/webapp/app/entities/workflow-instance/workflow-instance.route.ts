import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IWorkflowInstance, WorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { WorkflowInstanceService } from './workflow-instance.service';
import { WorkflowInstanceComponent } from './workflow-instance.component';
import { WorkflowInstanceDetailComponent } from './workflow-instance-detail.component';
import { WorkflowInstanceUpdateComponent } from './workflow-instance-update.component';

@Injectable({ providedIn: 'root' })
export class WorkflowInstanceResolve implements Resolve<IWorkflowInstance> {
  constructor(private service: WorkflowInstanceService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IWorkflowInstance> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((workflowInstance: HttpResponse<WorkflowInstance>) => {
          if (workflowInstance.body) {
            return of(workflowInstance.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new WorkflowInstance());
  }
}

export const workflowInstanceRoute: Routes = [
  {
    path: '',
    component: WorkflowInstanceComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: WorkflowInstanceDetailComponent,
    resolve: {
      workflowInstance: WorkflowInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: WorkflowInstanceUpdateComponent,
    resolve: {
      workflowInstance: WorkflowInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: WorkflowInstanceUpdateComponent,
    resolve: {
      workflowInstance: WorkflowInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstances'
    },
    canActivate: [UserRouteAccessService]
  }
];
