package de.winter.backend.model;


/**
 * 
 * @author Patrick Winter
 */


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TICKET")
public class Ticket {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TICKET_ID")
    private Long ticketID;

    @Column(name="TICKET_TITLE", length=50, nullable=false)
    private String title;

    @Column(name="TICKET_DESCRIPTION", length=500, nullable=false)
    private String description;

    @Column(name="TICKET_PRIORITY")
    private Priority priority;

    @Column(name="TICKET_TYPE")
    private Type type;

    @Column(name="TICKET_CREATE_DATE")
    private LocalDateTime createdDate;

    @Column(name="TICKET_COMPLETED")
    private LocalDateTime completedDate;


    // CONSTRUCTORS
    public Ticket(String title, String description, Priority priority, Type type) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.type = type;        
    }

    public Ticket() {
        this.createdDate = LocalDateTime.now();
    }


    // GETTER - SETTER - METHODS
    public Long getTicketID() {
        return ticketID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }


    @Override
    public String toString() {
        return "id=" + this.ticketID + ", " +
               "type=" + this.type + ", " +
               "title=" + this.title + ", " +
               "description=" +this.description + ", " +
               "priority=" + this.priority + ", " +
               "created=" + this.createdDate + ", " +
               "completed=" + this.completedDate;
    }

    public void setTicketID(Long ticketID2) {
    }
    
}
