import { Routes } from '@angular/router';

import { surveyComponentRoute } from './surveyComp/surveyComp.route'

const SURVEY_ROUTES = [surveyComponentRoute]

export const surveyRoute: Routes = [
  {
    path: '',
    children: SURVEY_ROUTES
  }
]
