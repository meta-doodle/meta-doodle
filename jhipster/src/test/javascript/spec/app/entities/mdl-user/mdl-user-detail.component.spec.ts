import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MdlTestModule } from '../../../test.module';
import { MdlUserDetailComponent } from 'app/entities/mdl-user/mdl-user-detail.component';
import { MdlUser } from 'app/shared/model/mdl-user.model';

describe('Component Tests', () => {
  describe('MdlUser Management Detail Component', () => {
    let comp: MdlUserDetailComponent;
    let fixture: ComponentFixture<MdlUserDetailComponent>;
    const route = ({ data: of({ mdlUser: new MdlUser(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MdlTestModule],
        declarations: [MdlUserDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdlUserDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdlUserDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdlUser on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdlUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
