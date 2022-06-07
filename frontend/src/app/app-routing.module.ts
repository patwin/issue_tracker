import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { TicketFormComponent } from './components/ticket-form/ticket-form.component';
import { TicketInformationComponent } from './components/ticket-information/ticket-information.component';
import { TicketListComponent } from './components/ticket-list/ticket-list.component';

const routes: Routes = [
  { path: "", redirectTo: "/home", pathMatch: "full"},
  { path: "home", component: HomeComponent },
  { path: "tickets", component: TicketListComponent },  
  { path: "tickets/add", component: TicketFormComponent }, 
  { path: "tickets/:id", component: TicketInformationComponent },
  { path: "**", component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
