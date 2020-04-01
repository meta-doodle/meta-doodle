import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IAnswer, Answer } from 'app/shared/model/answer.model';
import { AnswerService } from './answer.service';
import { AnswerComponent } from './answer.component';
import { AnswerDetailComponent } from './answer-detail.component';
import { AnswerUpdateComponent } from './answer-update.component';

@Injectable({ providedIn: 'root' })
export class AnswerResolve implements Resolve<IAnswer> {
  constructor(private service: AnswerService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IAnswer> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((answer: HttpResponse<Answer>) => {
          if (answer.body) {
            return of(answer.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Answer());
  }
}

export const answerRoute: Routes = [
  {
    path: '',
    component: AnswerComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Answers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AnswerDetailComponent,
    resolve: {
      answer: AnswerResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Answers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AnswerUpdateComponent,
    resolve: {
      answer: AnswerResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Answers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AnswerUpdateComponent,
    resolve: {
      answer: AnswerResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Answers'
    },
    canActivate: [UserRouteAccessService]
  }
];
