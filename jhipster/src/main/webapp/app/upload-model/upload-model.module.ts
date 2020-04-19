import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MdlSharedModule } from 'app/shared/shared.module';
import { UPLOADMODEL_ROUTE } from './upload-model.route';
import { UploadModelComponent } from './upload-model.component';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild([UPLOADMODEL_ROUTE])],
  declarations: [UploadModelComponent]
})
export class UploadModelModule {}
