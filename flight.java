

public class Flight {
    private final FlightTicket ticket;
    private int adultsNum, kidsNum, userCount;
    private Users [] userList;


    public Flight(String fromDestiniation, String toDestiniation, double price){
        ticket = new FlightTicket(fromDestiniation, toDestiniation, price);
        this.adultsNum = 0;
        this.kidsNum = 0;
        this.userList = new Users[10];
        this.userCount = 0;
        
        
    }

    public int getTicketCode(){
        return ticket.getTicket();
    }

    public int getUserCount(){
        return userCount;
    }

    public void addUser(Users user){
        userList[userCount] = user;
        userCount++;
    }
}