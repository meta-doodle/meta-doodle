import { IAnswer } from 'app/shared/model/answer.model';
import { IMdlUser } from 'app/shared/model/mdl-user.model';

export interface IWorkflowInstance {
  id?: number;
  stateId?: number;
  answers?: IAnswer[];
  wfModelId?: number;
  guests?: IMdlUser[];
  creatorId?: number;
}

export class WorkflowInstance implements IWorkflowInstance {
  constructor(
    public id?: number,
    public stateId?: number,
    public answers?: IAnswer[],
    public wfModelId?: number,
    public guests?: IMdlUser[],
    public creatorId?: number
  ) {}
}
