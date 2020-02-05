import { Route } from '@angular/router';

import { SondageComponent } from './sondage.component';

export const registerRoute: Route = {
  path: 'register',
  component: SondageComponent,
  data: {
    authorities: [],
    pageTitle: 'Sondage'
  }
};
