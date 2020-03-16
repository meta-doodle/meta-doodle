import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { StepComponent } from './step.component';
import { StepDetailComponent } from './step-detail.component';
import { StepUpdateComponent } from './step-update.component';
import { StepDeleteDialogComponent } from './step-delete-dialog.component';
import { stepRoute } from './step.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(stepRoute)],
  declarations: [StepComponent, StepDetailComponent, StepUpdateComponent, StepDeleteDialogComponent],
  entryComponents: [StepDeleteDialogComponent]
})
export class MdlStepModule {}
