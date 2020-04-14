/*
    This file is supposed to be erased soon, since it contains data format which
    should come from Jhipster. If you need to define an actual and permanent data
    format, use another file.
*/

import { IRestriction, IDateRestriction } from './options';

export interface IQuestion {
  reponseType: string;
  intitule: string;
  id: string;
  restrictions: Array<IRestriction> | IDateRestriction;
}

export interface IModel {
  id: number;
  title: string;
  description: string;
}
