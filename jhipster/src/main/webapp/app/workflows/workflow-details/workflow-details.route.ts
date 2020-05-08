import { Route, Resolve, Router, ActivatedRouteSnapshot } from '@angular/router';
import { WorkflowDetailsComponent } from './workflow-details.component';
import { Injectable } from '@angular/core';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { AnswerService } from 'app/entities/answer/answer.service';
import { Observable, of, EMPTY } from 'rxjs';
import { IAnswer, Answer } from 'app/shared/model/answer.model';
import { flatMap } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { resolve } from 'dns';



@Injectable({ providedIn: 'root' })
export class WorkflowResolve implements Resolve<IWorkflowInstance> {
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

export const WorkflowDetailRoute: Route =
  {
    path: 'workflow-details/:id/details',
    component: WorkflowDetailsComponent,
    resolve: { workflow: WorkflowResolve}
  }

