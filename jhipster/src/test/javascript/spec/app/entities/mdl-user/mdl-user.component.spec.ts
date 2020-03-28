import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MdlTestModule } from '../../../test.module';
import { MdlUserComponent } from 'app/entities/mdl-user/mdl-user.component';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { MdlUser } from 'app/shared/model/mdl-user.model';

describe('Component Tests', () => {
  describe('MdlUser Management Component', () => {
    let comp: MdlUserComponent;
    let fixture: ComponentFixture<MdlUserComponent>;
    let service: MdlUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [MdlUserComponent]
      })
        .overrideTemplate(MdlUserComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdlUserComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdlUserService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdlUser(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdlUsers && comp.mdlUsers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
