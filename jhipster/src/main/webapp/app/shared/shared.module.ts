import { NgModule } from '@angular/core';
import { MdlSharedLibsModule } from './shared-libs.module';

import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';

@NgModule({
  imports: [MdlSharedLibsModule],
  declarations: [AlertComponent, AlertErrorComponent, HasAnyAuthorityDirective],
  entryComponents: [],
  exports: [MdlSharedLibsModule, AlertComponent, AlertErrorComponent,  HasAnyAuthorityDirective]
})
export class MdlSharedModule {}
