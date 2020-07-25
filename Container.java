public class Container {
    Flight list [];
    int count;

    Container(){
        this.list = new Flight[10];
        this.count = 0;
    }

    public void addFlight(String from, String to, double price){
        this.list[this.count] = new Flight(from, to, price);
        count++; 
    }

    public int getCount(){
        return this.count;
    }

    public String displayInfo(){
        String str = "   ------------- Flight Information -------------\n";
        
        for(int i=0; i<count; i++){
        str += "Fly from: "+ list[i].ticket.getFromDestination();
        str += "\nFly to: "+ list[i].ticket.getToDestination();
        str += "\nPrice: "+ list[i].ticket.getPrice();
        str += "\n\n";
        }


        return str;
    }

    public Flight getFlight(int count){
        return list[count];
    }
}