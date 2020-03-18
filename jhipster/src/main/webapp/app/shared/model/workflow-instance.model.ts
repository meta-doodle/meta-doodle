import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';
import { IStep } from 'app/shared/model/step.model';
import { IMdlUser } from 'app/shared/model/mdl-user.model';

export interface IWorkflowInstance {
  id?: number;
  stepUserAnswers?: IStepUserAnswerWfInstance[];
  steps?: IStep[];
  guests?: IMdlUser[];
  wfModelId?: number;
  creatorId?: number;
}

export class WorkflowInstance implements IWorkflowInstance {
  constructor(
    public id?: number,
    public stepUserAnswers?: IStepUserAnswerWfInstance[],
    public steps?: IStep[],
    public guests?: IMdlUser[],
    public wfModelId?: number,
    public creatorId?: number
  ) {}
}
