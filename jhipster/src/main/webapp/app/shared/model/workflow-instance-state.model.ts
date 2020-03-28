import { ICurrentStep } from 'app/shared/model/current-step.model';

export interface IWorkflowInstanceState {
  id?: number;
  steps?: ICurrentStep[];
  workflowInstanceId?: number;
}

export class WorkflowInstanceState implements IWorkflowInstanceState {
  constructor(public id?: number, public steps?: ICurrentStep[], public workflowInstanceId?: number) {}
}
