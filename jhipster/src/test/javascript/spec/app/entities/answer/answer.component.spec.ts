import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { AnswerComponent } from 'app/entities/answer/answer.component';
import { AnswerService } from 'app/entities/answer/answer.service';
import { Answer } from 'app/shared/model/answer.model';

describe('Component Tests', () => {
  describe('Answer Management Component', () => {
    let comp: AnswerComponent;
    let fixture: ComponentFixture<AnswerComponent>;
    let service: AnswerService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [AnswerComponent]
      })
        .overrideTemplate(AnswerComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AnswerComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AnswerService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Answer(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.answers && comp.answers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
