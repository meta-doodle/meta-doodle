import { IMdlUser } from 'app/shared/model/mdl-user.model';

export interface ICurrentStep {
  id?: number;
  stepIdent?: number;
  numberOfAnswer?: number;
  users?: IMdlUser[];
  workflowInstanceStateId?: number;
}

export class CurrentStep implements ICurrentStep {
  constructor(
    public id?: number,
    public stepIdent?: number,
    public numberOfAnswer?: number,
    public users?: IMdlUser[],
    public workflowInstanceStateId?: number
  ) {}
}
