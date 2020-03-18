import { IAnswer } from 'app/shared/model/answer.model';

export interface IStepUserAnswerWfInstance {
  id?: number;
  stepId?: number;
  answers?: IAnswer[];
  mdlUserId?: number;
  workflowInstanceId?: number;
}

export class StepUserAnswerWfInstance implements IStepUserAnswerWfInstance {
  constructor(
    public id?: number,
    public stepId?: number,
    public answers?: IAnswer[],
    public mdlUserId?: number,
    public workflowInstanceId?: number
  ) {}
}
