import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ticket } from 'src/app/model/ticket';
import { TicketService } from 'src/app/service/ticket/ticket.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {
  tickets: Ticket[] = [];

  constructor(private router: Router, 
              private ticketService: TicketService) { }

  ngOnInit(): void {
    this.ticketService.findAll().subscribe(data => {
      this.tickets = data;
    });
  }

  delete(ticketID: number) {
    this.ticketService.deleteByID(ticketID).subscribe(data => this.reloadCurrentRoute());
  }

  reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
}
}
