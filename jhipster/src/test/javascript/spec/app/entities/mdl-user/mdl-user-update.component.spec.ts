import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { MdlUserUpdateComponent } from 'app/entities/mdl-user/mdl-user-update.component';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { MdlUser } from 'app/shared/model/mdl-user.model';

describe('Component Tests', () => {
  describe('MdlUser Management Update Component', () => {
    let comp: MdlUserUpdateComponent;
    let fixture: ComponentFixture<MdlUserUpdateComponent>;
    let service: MdlUserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [MdlUserUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdlUserUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdlUserUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdlUserService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdlUser(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdlUser();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
