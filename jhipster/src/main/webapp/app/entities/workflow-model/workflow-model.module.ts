import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { WorkflowModelComponent } from './workflow-model.component';
import { WorkflowModelDetailComponent } from './workflow-model-detail.component';
import { WorkflowModelUpdateComponent } from './workflow-model-update.component';
import { WorkflowModelDeleteDialogComponent } from './workflow-model-delete-dialog.component';
import { workflowModelRoute } from './workflow-model.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(workflowModelRoute)],
  declarations: [WorkflowModelComponent, WorkflowModelDetailComponent, WorkflowModelUpdateComponent, WorkflowModelDeleteDialogComponent],
  entryComponents: [WorkflowModelDeleteDialogComponent]
})
export class MdlWorkflowModelModule {}
