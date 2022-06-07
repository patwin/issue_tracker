import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketListComponent } from './components/ticket-list/ticket-list.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { TicketFormComponent } from './components/ticket-form/ticket-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TicketInformationComponent } from './components/ticket-information/ticket-information.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TicketListComponent,    
    FooterComponent, 
    HomeComponent, TicketFormComponent, TicketInformationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
