

public class Flight {
    protected FlightTicket ticket;
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

    public double getPrice(int count){
        double originalPrice = ticket.getPrice();
        double discountedPrice = 0;

        if(userList[count].getAge() <= 12 || userList[count].getAge() > 60){
            discountedPrice = originalPrice * userList[count].discPrice();
        }


        return originalPrice - discountedPrice;

    }

    public int getUserCount(){
        return userCount;
    }

    public void addUser(Users user){
        userList[userCount] = user;
        if(userList[userCount].getAge() <= 12){
            this.kidsNum++;
        }
        else{
            this.adultsNum++;
        }

        userCount++;
    }

    public Users getUser(int count){
        return userList[count];
    }

    public String displayInfo(){
        String str = "";
        str += "Fly from: "+ ticket.getFromDestination();
        str += "\nFly to: "+ ticket.getToDestination();
        str += "\nPrice: "+ ticket.getPrice();

        return str;
    }

   

    public String getFrom(){
        return ticket.getFromDestination();
    }
    

}