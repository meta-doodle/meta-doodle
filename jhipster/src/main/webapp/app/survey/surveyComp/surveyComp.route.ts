import { Route } from '@angular/router'

import { SurveyComponent } from './surveyComp.component'

export const surveyComponentRoute: Route = {
    path: 'user/1',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }

}
