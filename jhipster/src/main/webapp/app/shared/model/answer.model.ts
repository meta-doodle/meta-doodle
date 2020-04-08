import { AvailableTypes } from 'app/shared/model/enumerations/available-types.model';

export interface IAnswer {
  id?: number;
  stepIdent?: string;
  questionIdent?: string;
  type?: AvailableTypes;
  answer?: string;
  userId?: number;
  workflowInstanceId?: number;
}

export class Answer implements IAnswer {
  constructor(
    public id?: number,
    public stepIdent?: string,
    public questionIdent?: string,
    public type?: AvailableTypes,
    public answer?: string,
    public userId?: number,
    public workflowInstanceId?: number
  ) {}
}
