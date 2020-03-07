import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { MdlSharedModule } from 'app/shared/shared.module';
import { MdlCoreModule } from 'app/core/core.module';
import { MdlAppRoutingModule } from './app-routing.module';
import { MdlHomeModule } from './home/home.module';
import { FormsModule } from '@angular/forms';
import { MdlEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here

import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';


@NgModule({
  imports: [
    BrowserModule,
    MdlSharedModule,
    MdlCoreModule,
    MdlHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    MdlEntityModule,
    MdlAppRoutingModule,
    FormsModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class MdlAppModule { }
