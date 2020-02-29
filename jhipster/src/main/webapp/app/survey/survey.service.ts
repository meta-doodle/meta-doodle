export class SurveyService {
    answers: Object = {}

    setKey(key: string, value: string | Array<string>): void {
        this.answers[key] = value
    }
}