package de.winter.backend.repository;


/**
 * 
 * @author Patrick Winter
 */


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.winter.backend.model.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Override
    <S extends Ticket> S save(S entity);

    @Override
    Optional<Ticket> findById(Long id);
    
    @Override
    List<Ticket> findAll();

    @Override
    void deleteById(Long id);
    
}
