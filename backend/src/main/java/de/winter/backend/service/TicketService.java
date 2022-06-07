package de.winter.backend.service;


/**
 * 
 * @author Patrick Winter
 */


import java.util.List;

import org.springframework.stereotype.Service;

import de.winter.backend.dto.TicketRequest;
import de.winter.backend.model.Ticket;


@Service
public interface TicketService {
    
    void addTicket (TicketRequest ticketRequest);

    List<Ticket> getTickets();

    Ticket getTicket (Long id);

    void updateTicket (Long ticketID, TicketRequest ticketRequest);

    void deleteTicker (long id);
    
}
