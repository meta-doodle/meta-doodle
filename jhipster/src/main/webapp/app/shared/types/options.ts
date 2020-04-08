/*
    This file is supposed to be erased soon, since it contains data format which
    should come from Jhipster. If you need to define an actual and permanent data 
    format, use another file.
*/

export interface IRestriction {
  label: string;
  id: string;
}

export interface IDateRestriction {
  dateBegin: string;
  dateEnd: string;
}

export function instanceOfIDateRestriction(object: any): object is IDateRestriction {
  return 'dateBegin' in object;
}
