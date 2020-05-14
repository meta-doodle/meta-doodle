import { IQuestion } from '../types/question';

export interface ISurveyView {
    stepId : number
    questionViews: Array<IQuestion>
}
