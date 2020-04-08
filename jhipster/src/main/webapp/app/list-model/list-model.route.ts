import { Routes, Route } from '@angular/router';

import { ListModelComponent } from './list-model.component';
import { instantiateRoute } from './instantiate-model/instantiate-model.route';

const listRoute: Route = {
  path: '',
  component: ListModelComponent,
  data: {
    authorities: [],
    pageTitle: 'List-model'
  }
};

export const listModelRoute: Routes = [
  {
    path: '',
    children: [listRoute, instantiateRoute]
  }
];
