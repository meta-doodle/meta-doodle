import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { WorkflowInstanceStateComponent } from './workflow-instance-state.component';
import { WorkflowInstanceStateDetailComponent } from './workflow-instance-state-detail.component';
import { WorkflowInstanceStateUpdateComponent } from './workflow-instance-state-update.component';
import { WorkflowInstanceStateDeleteDialogComponent } from './workflow-instance-state-delete-dialog.component';
import { workflowInstanceStateRoute } from './workflow-instance-state.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(workflowInstanceStateRoute)],
  declarations: [
    WorkflowInstanceStateComponent,
    WorkflowInstanceStateDetailComponent,
    WorkflowInstanceStateUpdateComponent,
    WorkflowInstanceStateDeleteDialogComponent
  ],
  entryComponents: [WorkflowInstanceStateDeleteDialogComponent]
})
export class MdlWorkflowInstanceStateModule {}
