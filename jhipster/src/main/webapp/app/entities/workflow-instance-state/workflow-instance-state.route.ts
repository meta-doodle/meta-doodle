import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IWorkflowInstanceState, WorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';
import { WorkflowInstanceStateService } from './workflow-instance-state.service';
import { WorkflowInstanceStateComponent } from './workflow-instance-state.component';
import { WorkflowInstanceStateDetailComponent } from './workflow-instance-state-detail.component';
import { WorkflowInstanceStateUpdateComponent } from './workflow-instance-state-update.component';

@Injectable({ providedIn: 'root' })
export class WorkflowInstanceStateResolve implements Resolve<IWorkflowInstanceState> {
  constructor(private service: WorkflowInstanceStateService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IWorkflowInstanceState> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((workflowInstanceState: HttpResponse<WorkflowInstanceState>) => {
          if (workflowInstanceState.body) {
            return of(workflowInstanceState.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new WorkflowInstanceState());
  }
}

export const workflowInstanceStateRoute: Routes = [
  {
    path: '',
    component: WorkflowInstanceStateComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstanceStates'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: WorkflowInstanceStateDetailComponent,
    resolve: {
      workflowInstanceState: WorkflowInstanceStateResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstanceStates'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: WorkflowInstanceStateUpdateComponent,
    resolve: {
      workflowInstanceState: WorkflowInstanceStateResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstanceStates'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: WorkflowInstanceStateUpdateComponent,
    resolve: {
      workflowInstanceState: WorkflowInstanceStateResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WorkflowInstanceStates'
    },
    canActivate: [UserRouteAccessService]
  }
];
