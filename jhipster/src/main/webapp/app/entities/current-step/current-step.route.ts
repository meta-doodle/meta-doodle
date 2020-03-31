import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICurrentStep, CurrentStep } from 'app/shared/model/current-step.model';
import { CurrentStepService } from './current-step.service';
import { CurrentStepComponent } from './current-step.component';
import { CurrentStepDetailComponent } from './current-step-detail.component';
import { CurrentStepUpdateComponent } from './current-step-update.component';

@Injectable({ providedIn: 'root' })
export class CurrentStepResolve implements Resolve<ICurrentStep> {
  constructor(private service: CurrentStepService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICurrentStep> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((currentStep: HttpResponse<CurrentStep>) => {
          if (currentStep.body) {
            return of(currentStep.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CurrentStep());
  }
}

export const currentStepRoute: Routes = [
  {
    path: '',
    component: CurrentStepComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CurrentSteps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: CurrentStepDetailComponent,
    resolve: {
      currentStep: CurrentStepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CurrentSteps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CurrentStepUpdateComponent,
    resolve: {
      currentStep: CurrentStepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CurrentSteps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: CurrentStepUpdateComponent,
    resolve: {
      currentStep: CurrentStepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'CurrentSteps'
    },
    canActivate: [UserRouteAccessService]
  }
];
