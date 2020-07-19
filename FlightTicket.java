import java.util.Random;

public class FlightTicket{

    private int ticketCode;
    public FlightTicket(){
        Random  rand = new Random(); 
        this.ticketCode = rand.nextInt(99999) + 10000; // The code ticket will be generated randomly
    }

    public int getTicket(){
        return this.ticketCode;
    }
}