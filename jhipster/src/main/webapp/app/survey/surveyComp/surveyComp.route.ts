import { Route } from '@angular/router'

import { SurveyComponent } from './surveyComp.component'


  export const surveyComponentAdminRoute: Route =
  {
  path:':userid/:id',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

  }


