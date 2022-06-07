import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Ticket } from 'src/app/model/ticket';
import { TicketService } from 'src/app/service/ticket/ticket.service';
import { switchMap } from "rxjs/operators";
import { throwError } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-ticket-information',
  templateUrl: './ticket-information.component.html',
  styleUrls: ['./ticket-information.component.css']
})
export class TicketInformationComponent implements OnInit {

  @Input() currentTicket: Ticket = new Ticket();

  ticketForm = new FormGroup( {
    title: new FormControl(this.currentTicket.title, Validators.required),
    description: new FormControl("", Validators.required),
    priority: new FormControl("", Validators.required),
    type: new FormControl("", Validators.required),
  });

  public ticketID?: any;
  public ticket: Ticket | undefined;

  constructor(private ticketService: TicketService,
              private route: ActivatedRoute,
              private router: Router) {;
  }

  ngOnInit(): void {
    this.initForm(this.route.snapshot.params["id"]);   
  }

  private initForm (id: string): void {
    this.ticketService.getTicket(id).subscribe({
      next: (data) => {
        this.currentTicket = data;
        this.ticketForm.get("title")?.setValue(data.title);
        this.ticketForm.get("description")?.setValue(data.description);
        this.ticketForm.get("priority")?.setValue(data.priority);
        this.ticketForm.get("type")?.setValue(data.type);
      },
      error: (e) => console.error(e)
    });    
  }

  submit() {
    this.ticketService.update(this.currentTicket.ticketID, this.ticketForm.value).subscribe(result => this.cancel());
  }

  cancel() {
    this.router.navigate(["/tickets"]);
  }
}
