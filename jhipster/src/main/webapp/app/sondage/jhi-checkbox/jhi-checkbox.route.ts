import { Route } from '@angular/router';

import { JhiCheckboxComponent } from './jhi-checkbox.component';

export const registerRoute: Route = {
  path: 'register',
  component: JhiCheckboxComponent,
  data: {
    authorities: [],
    pageTitle: 'Sondage'
  }
};
