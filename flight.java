public class Flight {
    private final FlightTicket ticket;

    public Flight(){
        ticket = new FlightTicket();
    }

    public int getTicketCode(){
        return ticket.getTicket();
    }
}