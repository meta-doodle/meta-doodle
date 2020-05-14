import {AvailableTypes} from "../model/enumerations/available-types.model";

export interface  IQuestion {
  alreadyAnswered: boolean,
  options :Map<string,string>,
  possibleAnswers: Array<string>,
  questionID : string,
  questionType: AvailableTypes,
  response: string,
  title: string,
}


export interface IModel {
  id: number;
  title: string;
  description: string;
}
