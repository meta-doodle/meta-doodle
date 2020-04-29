import { Routes } from '@angular/router';

import { surveyComponentAdminRoute } from './surveyComp/surveyComp.route'

const SURVEY_ROUTES = [surveyComponentAdminRoute]

export const surveyRoute: Routes = [
  {
    path: '',
    children: SURVEY_ROUTES
  }
]
