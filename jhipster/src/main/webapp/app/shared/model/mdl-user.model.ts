import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';

export interface IMdlUser {
  id?: number;
  userId?: number;
  workflows?: IWorkflowModel[];
  stepUserAnswers?: IStepUserAnswerWfInstance[];
  workflowInstances?: IWorkflowInstance[];
  participants?: IWorkflowInstance[];
}

export class MdlUser implements IMdlUser {
  constructor(
    public id?: number,
    public userId?: number,
    public workflows?: IWorkflowModel[],
    public stepUserAnswers?: IStepUserAnswerWfInstance[],
    public workflowInstances?: IWorkflowInstance[],
    public participants?: IWorkflowInstance[]
  ) {}
}
