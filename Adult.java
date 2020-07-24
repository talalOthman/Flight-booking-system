public class Adult extends Users {

    public Adult(String name, int passportNum, int age){
        super(name, passportNum, age);
    }

    public String displayInfo(){
        String str = "";

        str += name + "    " + age + "\n";

        return str;
    }


    
}