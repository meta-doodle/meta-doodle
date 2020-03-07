import { Route } from '@angular/router'

import { SurveyComponent } from './surveyComp.component'

export const surveyComponentRoute: Route = {
    path: '',
    component: SurveyComponent,
    data: {
        authorities: [],
        pageTitle: 'Survey'
    }
}