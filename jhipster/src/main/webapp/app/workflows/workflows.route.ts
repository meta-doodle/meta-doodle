import { Routes } from '@angular/router';
import { WorkflowListRoute } from './workflow-list/workflow-list.route';
import { WorkflowDetailRoute } from './workflow-details/workflow-details.route';

const WORFLOW_ROUTE = [WorkflowListRoute, WorkflowDetailRoute];

export const WorkflowsRoute: Routes = [
  {
    path: '',
    children: WORFLOW_ROUTE
  }
]
