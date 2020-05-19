import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { ICurrentStep } from 'app/shared/model/current-step.model';

export interface IMdlUser {
  id?: number;
  userId?: number;
  creatorWfInstances?: IWorkflowInstance[];
  workflows?: IWorkflowModel[];
  roleId?: number;
  steps?: ICurrentStep[];
  workflowInstances?: IWorkflowInstance[];
}

export class MdlUser implements IMdlUser {
  constructor(
    public id?: number,
    public userId?: number,
    public creatorWfInstances?: IWorkflowInstance[],
    public workflows?: IWorkflowModel[],
    public roleId?: number,
    public steps?: ICurrentStep[],
    public workflowInstances?: IWorkflowInstance[]
  ) {}
}
