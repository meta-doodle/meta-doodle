// Angular Imports
import { NgModule } from '@angular/core';
import { MdlSharedModule } from 'app/shared/shared.module';
import { listModelRoute } from './list-model.route';
import { RouterModule } from '@angular/router';
// This Module's Components
import { ListModelComponent } from './list-model.component';
import { ModelComponent } from './model/model.component';
import { InstantiateModelComponent } from './instantiate-model/instantiate-model.component';

@NgModule({
  imports: [MdlSharedModule, RouterModule.forChild(listModelRoute)],
  declarations: [ListModelComponent, ModelComponent, InstantiateModelComponent],
  exports: [ListModelComponent]
})
export class ListModelModule {}
