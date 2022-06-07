package de.winter.backend.dto;

import java.time.LocalDateTime;

import de.winter.backend.model.Priority;
import de.winter.backend.model.Type;

public class TicketResponse {
    private Long ticketID;
    private String title;
    private String description;
    private Priority priority;
    private Type type;
    private LocalDateTime createdDate;
    private LocalDateTime completedDate;
    
    
    public TicketResponse(Long ticketID, String title, String description, Priority priority, Type type,
            LocalDateTime createdDate, LocalDateTime completedDate) {
        this.ticketID = ticketID;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
    }

    public TicketResponse() {
        this(null, "", "", null, null, null, null);
    }


    public Long getTicketID() {
        return ticketID;
    }


    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
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


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public LocalDateTime getCompletedDate() {
        return completedDate;
    }


    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }
}
