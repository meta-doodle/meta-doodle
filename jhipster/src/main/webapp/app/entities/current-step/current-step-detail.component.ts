import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICurrentStep } from 'app/shared/model/current-step.model';

@Component({
  selector: 'jhi-current-step-detail',
  templateUrl: './current-step-detail.component.html'
})
export class CurrentStepDetailComponent implements OnInit {
  currentStep: ICurrentStep | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ currentStep }) => {
      this.currentStep = currentStep;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
