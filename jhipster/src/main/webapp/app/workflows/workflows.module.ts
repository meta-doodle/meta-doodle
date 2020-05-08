import { NgModule } from '@angular/core';
import { MdlSharedModule } from 'app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { WorkflowsRoute } from './workflows.route';
import { WorkflowDetailsComponent } from './workflow-details/workflow-details.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';
import { from } from 'rxjs';




@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(WorkflowsRoute)],
  declarations: [WorkflowDetailsComponent, WorkflowListComponent],
  providers: []
})
export class WorkflowModule {}
