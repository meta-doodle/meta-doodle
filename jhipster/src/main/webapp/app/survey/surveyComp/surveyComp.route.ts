import { Route } from '@angular/router'

import { SurveyComponent } from './surveyComp.component'


export const surveyComponentRoute: Route =
  {
  path:'user/1',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

  }

  export const surveyComponentAdminRoute: Route =
  {
  path:'admin/1',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

  }


