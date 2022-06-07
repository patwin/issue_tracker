package de.winter.backend.dto;


/**
 * 
 * @author Patrick Winter
 */


import de.winter.backend.model.Priority;
import de.winter.backend.model.Type;


public class TicketRequest {

    private Long ticketID;
    private String title;
    private String description;
    private Priority priority;
    private Type type;

    
    public TicketRequest(Long ticketID, String title, String description, String priority, String type) {
        this.ticketID = ticketID;
        this.title = title;
        this.description = description;
        this.priority = Priority.valueOf(priority);
        this.type = Type.valueOf(type);
    }


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
}
