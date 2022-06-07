export class Ticket {
    ticketID!: number;
    title!: string;
    description!: string;
    priority!: "LOW" | "HIGH";
    type!: "FEATURE" | "BUG" | "DOCUMENTATION";
    createdDate!: Date;
    completedDate?: Date;
  }  