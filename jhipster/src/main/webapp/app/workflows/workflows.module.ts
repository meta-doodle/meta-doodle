import { NgModule } from '@angular/core';
import { MdlSharedModule } from 'app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { WorkflowsRoute } from './workflows.route';
import { WorkflowDetailsComponent } from './workflow-details/workflow-details.component';
import { WorkflowListComponent } from './workflow-list/workflow-list.component';
import { UserManageComponent } from './user-manage/user-manage.component';
import { UserManageDetailsComponent} from './user-manage-details/user-manage-details.component'
import { from } from 'rxjs';




@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(WorkflowsRoute)],
  declarations: [WorkflowDetailsComponent, WorkflowListComponent, UserManageComponent, UserManageDetailsComponent],
  providers: []
})
export class WorkflowModule {}
