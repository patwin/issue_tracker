import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Ticket } from "../../model/ticket";
import { Observable } from 'rxjs';

const baseUrl = "http://localhost:8080/tickets";
@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(baseUrl);
  }

  public save(ticket: Ticket) {
    return this.http.post<Ticket>(baseUrl, ticket);
  }

  public update(id: number, ticket: Ticket) {
    return this.http.post<Ticket>(baseUrl + "/" + id, ticket);
  }

  public deleteByID(ticketID: number) {
    return this.http.post<Number>(baseUrl + "/delete", ticketID);
  }

  getTicket(ticketID: any): Observable<Ticket> {
    return this.http.get<Ticket>(baseUrl + "/" + ticketID);
  }
}
