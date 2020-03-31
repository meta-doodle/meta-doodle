import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdlUser, MdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from './mdl-user.service';
import { MdlUserComponent } from './mdl-user.component';
import { MdlUserDetailComponent } from './mdl-user-detail.component';
import { MdlUserUpdateComponent } from './mdl-user-update.component';

@Injectable({ providedIn: 'root' })
export class MdlUserResolve implements Resolve<IMdlUser> {
  constructor(private service: MdlUserService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdlUser> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdlUser: HttpResponse<MdlUser>) => {
          if (mdlUser.body) {
            return of(mdlUser.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdlUser());
  }
}

export const mdlUserRoute: Routes = [
  {
    path: '',
    component: MdlUserComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'MdlUsers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdlUserDetailComponent,
    resolve: {
      mdlUser: MdlUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'MdlUsers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdlUserUpdateComponent,
    resolve: {
      mdlUser: MdlUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'MdlUsers'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdlUserUpdateComponent,
    resolve: {
      mdlUser: MdlUserResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'MdlUsers'
    },
    canActivate: [UserRouteAccessService]
  }
];
