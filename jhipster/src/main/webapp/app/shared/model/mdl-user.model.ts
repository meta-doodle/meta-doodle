import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { IWorkflowModel } from 'app/shared/model/workflow-model.model';

export interface IMdlUser {
  id?: number;
  userId?: number;
  creatorWfInstances?: IWorkflowInstance[];
  workflows?: IWorkflowModel[];
  currentStepId?: number;
  workflowInstances?: IWorkflowInstance[];
}

export class MdlUser implements IMdlUser {
  constructor(
    public id?: number,
    public userId?: number,
    public creatorWfInstances?: IWorkflowInstance[],
    public workflows?: IWorkflowModel[],
    public currentStepId?: number,
    public workflowInstances?: IWorkflowInstance[]
  ) {}
}
