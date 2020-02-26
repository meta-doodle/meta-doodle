import { Component, OnInit } from '@angular/core';
import { IQuestion } from '../../shared/types/temp'
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
    answerType: 'RADIO',
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

  initForm(): void {
    const group = {}

    this.questions.forEach((question: IQuestion) => {
      group[question.id] = ""
    })

    // to delete
    group["drinkPreference"] = ""

    this.surveyForm = this.formBuilder.group(group)
  }

  submit(): void {
    const formValue = this.surveyForm.value;
    /* debugger; */
  }
}


interface FormEntry {
  key: string,
  value: string
}