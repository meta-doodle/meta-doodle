import { IWorkflowModel } from 'app/shared/model/workflow-model.model';
import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';

export interface IMdlUser {
  id?: number;
  userId?: number;
  createdWfModels?: IWorkflowModel[];
  stepUserAnswers?: IStepUserAnswerWfInstance[];
  createdWfInstances?: IWorkflowInstance[];
  memberWfInstances?: IWorkflowInstance[];
}

export class MdlUser implements IMdlUser {
  constructor(
    public id?: number,
    public userId?: number,
    public createdWfModels?: IWorkflowModel[],
    public stepUserAnswers?: IStepUserAnswerWfInstance[],
    public createdWfInstances?: IWorkflowInstance[],
    public memberWfInstances?: IWorkflowInstance[]
  ) {}
}
