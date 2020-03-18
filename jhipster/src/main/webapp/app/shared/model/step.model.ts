import { Moment } from 'moment';

export interface IStep {
  id?: number;
  mandatory?: number;
  answered?: number;
  deadline?: Moment;
  nextStep?: number;
  stepUserAnswerId?: number;
  wfInstanceId?: number;
}

export class Step implements IStep {
  constructor(
    public id?: number,
    public mandatory?: number,
    public answered?: number,
    public deadline?: Moment,
    public nextStep?: number,
    public stepUserAnswerId?: number,
    public wfInstanceId?: number
  ) {}
}
