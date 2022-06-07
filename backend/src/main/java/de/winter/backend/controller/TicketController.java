package de.winter.backend.controller;


/**
 * 
 * @author Patrick Winter
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.winter.backend.dto.TicketRequest;
import de.winter.backend.model.Ticket;
import de.winter.backend.service.TicketService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    

    // CONSTRUCTORS
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @RequestMapping(method=RequestMethod.GET)
    public List<Ticket> getTickets() {
        return this.ticketService.getTickets();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addTicket (@RequestBody TicketRequest ticketRequest) {
        this.ticketService.addTicket(ticketRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    } 
    @RequestMapping(method = RequestMethod.POST, value="/{id}")
    public ResponseEntity updateTicket (@PathVariable Long id, @RequestBody TicketRequest ticketRequest) {
        this.ticketService.updateTicket(id, ticketRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
    
    @RequestMapping(method = RequestMethod.POST, value="/delete")
    public ResponseEntity deleteTicket (@RequestBody Long ticketID) {
        this.ticketService.deleteTicker(ticketID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
