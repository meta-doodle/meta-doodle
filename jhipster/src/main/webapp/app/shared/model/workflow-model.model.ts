export interface IWorkflowModel {
  id?: number;
  title?: string;
  description?: string;
  body?: string;
  creatorId?: number;
}

export class WorkflowModel implements IWorkflowModel {
  constructor(public id?: number, public title?: string, public description?: string, public body?: string, public creatorId?: number) {}
}
