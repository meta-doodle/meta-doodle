import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IStep, Step } from 'app/shared/model/step.model';
import { StepService } from './step.service';
import { StepComponent } from './step.component';
import { StepDetailComponent } from './step-detail.component';
import { StepUpdateComponent } from './step-update.component';

@Injectable({ providedIn: 'root' })
export class StepResolve implements Resolve<IStep> {
  constructor(private service: StepService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IStep> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((step: HttpResponse<Step>) => {
          if (step.body) {
            return of(step.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Step());
  }
}

export const stepRoute: Routes = [
  {
    path: '',
    component: StepComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Steps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: StepDetailComponent,
    resolve: {
      step: StepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Steps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: StepUpdateComponent,
    resolve: {
      step: StepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Steps'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: StepUpdateComponent,
    resolve: {
      step: StepResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Steps'
    },
    canActivate: [UserRouteAccessService]
  }
];
