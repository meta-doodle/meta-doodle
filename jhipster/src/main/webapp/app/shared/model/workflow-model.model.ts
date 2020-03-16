import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';

export interface IWorkflowModel {
  id?: number;
  title?: string;
  description?: string;
  body?: string;
  wfsinstances?: IWorkflowInstance[];
  authorId?: number;
}

export class WorkflowModel implements IWorkflowModel {
  constructor(
    public id?: number,
    public title?: string,
    public description?: string,
    public body?: string,
    public wfsinstances?: IWorkflowInstance[],
    public authorId?: number
  ) {}
}
