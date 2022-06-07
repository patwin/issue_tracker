import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TicketService } from 'src/app/service/ticket/ticket.service';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent implements OnInit {
  ticketForm = new FormGroup( {
    title: new FormControl("", Validators.required),
    description: new FormControl("", Validators.required),
    priority: new FormControl("", Validators.required),
    type: new FormControl("", Validators.required),
  });
  

  constructor(private router: Router,
              private ticketService: TicketService) { }

  ngOnInit(): void { }

  submit() {
    this.ticketService.save(this.ticketForm.value).subscribe(result => this.cancel());
  }

  cancel() {
    this.router.navigate(["/tickets"]);
  }
}
