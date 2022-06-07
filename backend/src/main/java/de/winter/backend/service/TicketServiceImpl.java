package de.winter.backend.service;


/**
 * 
 * @author Patrick Winter
 */


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.winter.backend.dto.TicketRequest;
import de.winter.backend.model.Ticket;
import de.winter.backend.repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public void addTicket (TicketRequest ticketRequest) {
        this.ticketRepository.save(this.ticketRequestToTicket(ticketRequest));
    }

    @Transactional
    @Override
    public List<Ticket> getTickets() {
        return this.ticketRepository.findAll();
    }

    @Transactional
    @Override
    public Ticket getTicket(Long id) {
        return this.ticketRepository.findById(id).get();
    }

    @Override
    public void updateTicket(Long ticketID, TicketRequest ticketRequest) {
        Ticket currentTicket = this.getTicket(ticketID);
        currentTicket.setTitle(ticketRequest.getTitle());
        currentTicket.setDescription(ticketRequest.getDescription());
        currentTicket.setType(ticketRequest.getType());
        currentTicket.setPriority(ticketRequest.getPriority());
        this.ticketRepository.save(currentTicket);        
    }

    @Override
    public void deleteTicker(long id) {
        this.ticketRepository.deleteById(id);        
    }


    private Ticket ticketRequestToTicket (TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketRequest.getTitle());
        ticket.setDescription(ticketRequest.getDescription());
        ticket.setType(ticketRequest.getType());
        ticket.setPriority(ticketRequest.getPriority());

        return ticket;
    }
}
