import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MdlSharedModule } from 'app/shared/shared.module';
import { MdlUserComponent } from './mdl-user.component';
import { MdlUserDetailComponent } from './mdl-user-detail.component';
import { MdlUserUpdateComponent } from './mdl-user-update.component';
import { MdlUserDeleteDialogComponent } from './mdl-user-delete-dialog.component';
import { mdlUserRoute } from './mdl-user.route';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(mdlUserRoute)],
  declarations: [MdlUserComponent, MdlUserDetailComponent, MdlUserUpdateComponent, MdlUserDeleteDialogComponent],
  entryComponents: [MdlUserDeleteDialogComponent]
})
export class MdlMdlUserModule {}
