import java.util.ArrayList;

public class Flight {
    private final FlightTicket ticket;
    private int adultsNum, kidsNum;
    private ArrayList<Users> userList;

    public Flight(String fromDestiniation, String toDestiniation, double price){
        ticket = new FlightTicket(fromDestiniation, toDestiniation, price);
        this.adultsNum = 0;
        this.kidsNum = 0;
        userList = new ArrayList<Users>();
        
    }

    public int getTicketCode(){
        return ticket.getTicket();
    }
}