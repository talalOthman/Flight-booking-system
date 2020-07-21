import java.util.Random;

public class FlightTicket{

    private String fromDestination, toDestination;
    private int ticketCode;
    private double price;
    


    public FlightTicket(String fromDestination, String toDestination, double price){
        
        Random  rand = new Random(); 
        this.ticketCode = rand.nextInt(99999) + 10000; // The code ticket will be generated randomly

        this.fromDestination = fromDestination;
        this.toDestination = toDestination;
        this.price = price;
    }


    public int getTicket(){
        return this.ticketCode;
    }
}