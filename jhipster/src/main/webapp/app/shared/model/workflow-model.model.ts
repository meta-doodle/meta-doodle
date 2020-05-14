export interface IWorkflowModel {
  id?: number;
  title?: string;
  description?: string;
  body?: any;
  creatorId?: number;
}

export class WorkflowModel implements IWorkflowModel {
  constructor(public id?: number, public title?: string, public description?: string, public body?: any, public creatorId?: number) {}
}
