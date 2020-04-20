import { Route } from '@angular/router';

import {UploadModelComponent} from "./upload-model.component";

export const UPLOADMODEL_ROUTE: Route = {
  path: '',
  component: UploadModelComponent,
  data: {
    authorities: [],
    pageTitle: 'Créer'
  }
};
