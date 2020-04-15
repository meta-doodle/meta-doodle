import { Routes } from '@angular/router';

import { surveyComponentRoute, surveyComponentAdminRoute } from './surveyComp/surveyComp.route'

const SURVEY_ROUTES = [surveyComponentRoute, surveyComponentAdminRoute]

export const surveyRoute: Routes = [
  {
    path: '',
    children: SURVEY_ROUTES
  }
]
