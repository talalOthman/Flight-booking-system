public class Adult extends Users{

    public Adult(String name, int passportNum, int age){
        super(name, passportNum, age);
    }

    public String displayInfo(){
        String str = "";

        str += "Name:         " + name + "\n";
        str += "Passport:    " + passportNum + "\n";
        str += "User's Age: " + age;

        return str;
    }

    public double discPrice(){
        return SeniorDISC;
    }


    
}