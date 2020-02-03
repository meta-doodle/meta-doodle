import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MdlSharedModule } from 'app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { eventsState } from './events.route';
import { ManageComponent } from './manage/manage.component';
import { EventItemComponent } from './event-item/event-item.component';
import { EventListComponent } from './event-list/event-list.component';



@NgModule({
  declarations: [SidebarComponent, ManageComponent, EventItemComponent, EventListComponent],
  imports: [
    MdlSharedModule,
    RouterModule.forChild(eventsState)
  ]
})
export class EventsModule { }
