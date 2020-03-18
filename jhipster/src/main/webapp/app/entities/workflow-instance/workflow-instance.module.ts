import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { WorkflowInstanceComponent } from './workflow-instance.component';
import { WorkflowInstanceDetailComponent } from './workflow-instance-detail.component';
import { WorkflowInstanceUpdateComponent } from './workflow-instance-update.component';
import { WorkflowInstanceDeleteDialogComponent } from './workflow-instance-delete-dialog.component';
import { workflowInstanceRoute } from './workflow-instance.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(workflowInstanceRoute)],
  declarations: [
    WorkflowInstanceComponent,
    WorkflowInstanceDetailComponent,
    WorkflowInstanceUpdateComponent,
    WorkflowInstanceDeleteDialogComponent
  ],
  entryComponents: [WorkflowInstanceDeleteDialogComponent]
})
export class MdlWorkflowInstanceModule {}
