import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { StepUserAnswerWfInstanceComponent } from './step-user-answer-wf-instance.component';
import { StepUserAnswerWfInstanceDetailComponent } from './step-user-answer-wf-instance-detail.component';
import { StepUserAnswerWfInstanceUpdateComponent } from './step-user-answer-wf-instance-update.component';
import { StepUserAnswerWfInstanceDeleteDialogComponent } from './step-user-answer-wf-instance-delete-dialog.component';
import { stepUserAnswerWfInstanceRoute } from './step-user-answer-wf-instance.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(stepUserAnswerWfInstanceRoute)],
  declarations: [
    StepUserAnswerWfInstanceComponent,
    StepUserAnswerWfInstanceDetailComponent,
    StepUserAnswerWfInstanceUpdateComponent,
    StepUserAnswerWfInstanceDeleteDialogComponent
  ],
  entryComponents: [StepUserAnswerWfInstanceDeleteDialogComponent]
})
export class MdlStepUserAnswerWfInstanceModule {}
