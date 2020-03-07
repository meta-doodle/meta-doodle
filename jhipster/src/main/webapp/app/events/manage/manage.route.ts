import { Route } from '@angular/router';
import { ManageComponent } from './manage.component';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';

export const manageRoute: Route = {
    path: 'manage',
    component: ManageComponent,
    data: {
        /* authorities: ['ROLE_USER'], */
        pageTitle: 'Gérer'
    },
    canActivate: [UserRouteAccessService]
}