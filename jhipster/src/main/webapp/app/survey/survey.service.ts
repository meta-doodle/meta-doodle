export class SurveyService {
    answers: Object = {}

    setKey(key: string, value: string): void {
        this.answers[key] = value
    }
}