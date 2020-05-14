export class SurveyService {
    answers: Object = {}

    setKey(key: string, value: string | Array<string>): void {
        this.answers[key] = value
    }

    getValue(key: string): string | Array<string> {
      return this.answers[key] ? this.answers[key] : '';
    }
}
