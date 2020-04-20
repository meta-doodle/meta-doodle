import { Route } from '@angular/router'

import { SurveyComponent } from './surveyComp.component'


export const surveyComponentRoute: Route =
  {
  path:'user/2',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

  }

  export const surveyComponentAdminRoute: Route =
  {
  path:'admin/2',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

  }


