import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { CurrentStepComponent } from './current-step.component';
import { CurrentStepDetailComponent } from './current-step-detail.component';
import { CurrentStepUpdateComponent } from './current-step-update.component';
import { CurrentStepDeleteDialogComponent } from './current-step-delete-dialog.component';
import { currentStepRoute } from './current-step.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(currentStepRoute)],
  declarations: [CurrentStepComponent, CurrentStepDetailComponent, CurrentStepUpdateComponent, CurrentStepDeleteDialogComponent],
  entryComponents: [CurrentStepDeleteDialogComponent]
})
export class MdlCurrentStepModule {}
