import { Route } from '@angular/router';
import { InstantiateModelComponent } from './instantiate-model.component';

export const instantiateRoute: Route = {
  path: 'instantiate/:id',
  component: InstantiateModelComponent,
  data: {
    authorities: [],
    pageTitle: 'List-model'
  }
};
