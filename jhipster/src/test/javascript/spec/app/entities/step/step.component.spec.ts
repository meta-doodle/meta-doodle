import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { StepComponent } from 'app/entities/step/step.component';
import { StepService } from 'app/entities/step/step.service';
import { Step } from 'app/shared/model/step.model';

describe('Component Tests', () => {
  describe('Step Management Component', () => {
    let comp: StepComponent;
    let fixture: ComponentFixture<StepComponent>;
    let service: StepService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [StepComponent],
        providers: []
      })
        .overrideTemplate(StepComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(StepComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(StepService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Step(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.steps && comp.steps[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
