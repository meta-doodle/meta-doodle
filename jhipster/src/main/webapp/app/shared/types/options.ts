
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
