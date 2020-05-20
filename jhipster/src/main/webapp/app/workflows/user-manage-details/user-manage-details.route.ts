import { Route } from '@angular/router';
import { UserManageDetailsComponent } from './user-manage-details.component';

export const UserManageDetailRoute: Route =
  {
    path: 'user-manage/:id',
    component: UserManageDetailsComponent
  }
