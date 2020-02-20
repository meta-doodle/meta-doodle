import { Component, OnInit } from '@angular/core';
import { IQuestion, IRestriction } from '../../shared/types/temp'
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'jhi-survey',
  templateUrl: './surveyComp.component.html',
  styleUrls: ['./surveyComp.component.scss']
})
export class SurveyComponent implements OnInit {

  questions: Array<IQuestion> = [{
    answerType: 'RADIO',
    title: 'La vie, dans son sens intemporel, universel et grandiloquent, a-t-elle une once de sens ?',
    id: "vie",
    restrictions: [
      {
        label: 'Café',
        id: 'vie-cafe'
      },
      {
        label: 'UwU',
        id: 'vie-uwu'
      }
    ]
  },
  {
    answerType: 'CHECKBOX',
    title: 'Ils sont où les quignons à Kadoc ?',
    id: "quignons",
    restrictions: [
      {
        label: 'Ils sont bien cachés',
        id: 'quignons-caches'
      },
      {
        label: 'Ils sont dans la poche',
        id: 'quignons-poche'
      }
    ]
  }
  ];

  // index = 0;
  surveyForm: FormGroup
  formKeys: Array<string> = []

  constructor(private formBuilder: FormBuilder) {
    this.surveyForm = this.formBuilder.group({})
  }

  ngOnInit(): void {
    this.initForm()
  }

  initForm() {
    let formGroup: Array<formEntry> = []
    this.questions.forEach((question: IQuestion, index) => {
      question.restrictions.forEach((rest: IRestriction, index) => {
        var entry = { key: rest.id, value: "" }
        formGroup.push(entry)
        this.formKeys.push(rest.id)
      })
    })
    this.surveyForm = this.formBuilder.group(formGroup)
  }


  /* getCurrentQuestion(): IQuestion {
    return this.questions[this.index];
  }

  incrQuestionIndex(): void {
    this.index++
  }

  getType(): string {
    return this.questions[this.index].answerType;
  } */

  submit(): void {
    const formValue = this.surveyForm.value
    // console.log(formValue)
    const result: Array<formEntry> = []
    this.formKeys.forEach((key, index) => {
      var entry: formEntry = { key: key, value: formValue[key] }
      result.push(entry)
    })
    // console.log(result)
  }
}


interface formEntry {
  key: string,
  value: string
}