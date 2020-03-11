import { Routes } from '@angular/router';
import { manageRoute } from './manage/manage.route';

const EVENTS_ROUTES = [manageRoute];

export const eventsState: Routes = [
  {
    path: '',
    children: EVENTS_ROUTES
  }
];
