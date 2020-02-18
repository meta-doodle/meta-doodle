import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';
import { SondageComponent } from 'app/sondage/sondage.component';
import { JhiCheckboxComponent } from 'app/sondage/jhi-checkbox/jhi-checkbox.component';
import { JhiRadioComponent } from 'app/sondage/jhi-radio/jhi-radio.component';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent, SondageComponent, JhiCheckboxComponent, JhiRadioComponent]
})
export class MdlHomeModule {}
