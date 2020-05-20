export interface IRole {
  id?: number;
  role?: string;
  userId?: number;
  workflowInstanceId?: number;
}

export class Role implements IRole {
  constructor(public id?: number, public role?: string, public userId?: number, public workflowInstanceId?: number) {}
}

export class URole implements IRole {
  constructor(public role?: string, public userId?: number, public workflowInstanceId?: number) {}
}
