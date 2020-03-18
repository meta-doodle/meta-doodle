import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IStepUserAnswerWfInstance, StepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { StepUserAnswerWfInstanceService } from './step-user-answer-wf-instance.service';
import { StepUserAnswerWfInstanceComponent } from './step-user-answer-wf-instance.component';
import { StepUserAnswerWfInstanceDetailComponent } from './step-user-answer-wf-instance-detail.component';
import { StepUserAnswerWfInstanceUpdateComponent } from './step-user-answer-wf-instance-update.component';

@Injectable({ providedIn: 'root' })
export class StepUserAnswerWfInstanceResolve implements Resolve<IStepUserAnswerWfInstance> {
  constructor(private service: StepUserAnswerWfInstanceService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IStepUserAnswerWfInstance> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((stepUserAnswerWfInstance: HttpResponse<StepUserAnswerWfInstance>) => {
          if (stepUserAnswerWfInstance.body) {
            return of(stepUserAnswerWfInstance.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new StepUserAnswerWfInstance());
  }
}

export const stepUserAnswerWfInstanceRoute: Routes = [
  {
    path: '',
    component: StepUserAnswerWfInstanceComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'StepUserAnswerWfInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: StepUserAnswerWfInstanceDetailComponent,
    resolve: {
      stepUserAnswerWfInstance: StepUserAnswerWfInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'StepUserAnswerWfInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: StepUserAnswerWfInstanceUpdateComponent,
    resolve: {
      stepUserAnswerWfInstance: StepUserAnswerWfInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'StepUserAnswerWfInstances'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: StepUserAnswerWfInstanceUpdateComponent,
    resolve: {
      stepUserAnswerWfInstance: StepUserAnswerWfInstanceResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'StepUserAnswerWfInstances'
    },
    canActivate: [UserRouteAccessService]
  }
];
