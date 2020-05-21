import { Route } from '@angular/router';

import { SidebarComponent } from './sidebar.component';

export const sidebarRoute: Route = {
  path: '',
  component: SidebarComponent,
  outlet: 'sidebar'
};
