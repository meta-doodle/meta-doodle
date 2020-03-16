export interface IAnswer {
  id?: number;
  resp?: string;
  stepUserAnswerId?: number;
}

export class Answer implements IAnswer {
  constructor(public id?: number, public resp?: string, public stepUserAnswerId?: number) {}
}
