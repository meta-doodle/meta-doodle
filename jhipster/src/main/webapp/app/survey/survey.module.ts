import { NgModule } from "@angular/core";
import { MdlSharedModule } from 'app/shared/shared.module';
import { RouterModule } from '@angular/router';

import { SurveyComponent } from './surveyComp/surveyComp.component'
import { JhiRadioComponent } from './jhi-radio/jhi-radio.component'
import { JhiCheckboxComponent } from './jhi-checkbox/jhi-checkbox.component'
import { surveyRoute } from './survey.route';
import { QuestionComponent } from './question/question.component';

@NgModule({
    imports: [MdlSharedModule, RouterModule.forChild(surveyRoute)],
    declarations: [
        SurveyComponent,
        JhiCheckboxComponent,
        JhiRadioComponent,
        QuestionComponent
    ]
})
export class SurveyModule { }