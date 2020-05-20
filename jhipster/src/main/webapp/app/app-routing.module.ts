import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute } from './layouts/error/error.route';
import { navbarRoute } from './layouts/navbar/navbar.route';
import { sidebarRoute } from './layouts/sidebar/sidebar.route';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';


const LAYOUT_ROUTES = [navbarRoute, sidebarRoute, ...errorRoute];

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: 'admin',
          data: {
            authorities: ['ROLE_ADMIN']
          },
          canActivate: [UserRouteAccessService],
          loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule)
        },
        {
          path: 'account',
          loadChildren: () => import('./account/account.module').then(m => m.AccountModule)
        },
        {
          path: 'list-model',
          loadChildren: () => import('./list-model/list-model.module').then(m => m.ListModelModule)
        },
        {
        path: 'upload-model',
        loadChildren: () => import('./upload-model/upload-model.module').then(m => m.UploadModelModule)
        },
        {
          path: 'login',
          loadChildren: () => import('./login/login.module').then(m => m.MdlLoginModule)
        },
        {
          path: 'events',
          loadChildren: () => import('./events/events.module').then(m => m.EventsModule)
        },
        {
          path: 'survey',
          loadChildren: () => import('./survey/survey.module').then(m => m.SurveyModule)
        },
        {
          path: 'workflows',
          loadChildren: () => import('./workflows/workflows.module').then(m=> m.WorkflowModule)
        },
        ...LAYOUT_ROUTES
      ],
      { enableTracing: DEBUG_INFO_ENABLED }
    )
  ],
  exports: [RouterModule]
})
export class MdlAppRoutingModule {}
