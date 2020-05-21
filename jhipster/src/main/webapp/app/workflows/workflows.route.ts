import { Routes } from '@angular/router';
import { WorkflowListRoute } from './workflow-list/workflow-list.route';
import { WorkflowDetailRoute } from './workflow-details/workflow-details.route';
import { userManageRoute } from './user-manage/user-manage.route';
import { UserManageDetailRoute } from './user-manage-details/user-manage-details.route'
  import { from } from 'rxjs';

const WORFLOW_ROUTE = [WorkflowListRoute, WorkflowDetailRoute, userManageRoute, UserManageDetailRoute];

export const WorkflowsRoute: Routes = [
  {
    path: '',
    children: WORFLOW_ROUTE
  }
]
