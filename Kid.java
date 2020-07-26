public class Kid extends Users{

    private String parentName;

    public Kid(String name, int passportNum, String parentName, int age){
        super(name, passportNum, age);
        this.parentName = parentName;
    }

    public String getParentName(){
        return this.parentName;
    }

    public void changeParentName(String newParentName){
        this.parentName = newParentName;
    }

    public String displayInfo(){
        String str = "";

        str += "Name:         " + name + "\n";
        str += "Parent:        " + parentName + "\n";
        str += "Passport:    " + passportNum + "\n";
        str += "User's Age: " + age;


        return str;
    }

    public double discPrice(){
        return KidDISC;
    }

    
}