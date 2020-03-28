import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { CurrentStepComponent } from 'app/entities/current-step/current-step.component';
import { CurrentStepService } from 'app/entities/current-step/current-step.service';
import { CurrentStep } from 'app/shared/model/current-step.model';

describe('Component Tests', () => {
  describe('CurrentStep Management Component', () => {
    let comp: CurrentStepComponent;
    let fixture: ComponentFixture<CurrentStepComponent>;
    let service: CurrentStepService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [CurrentStepComponent]
      })
        .overrideTemplate(CurrentStepComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CurrentStepComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CurrentStepService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CurrentStep(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.currentSteps && comp.currentSteps[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
