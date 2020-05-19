import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';

export interface IRole {
  id?: number;
  role?: string;
  users?: IMdlUser[];
  workflowInstances?: IWorkflowInstance[];
}

export class Role implements IRole {
  constructor(public id?: number, public role?: string, public users?: IMdlUser[], public workflowInstances?: IWorkflowInstance[]) {}
}
