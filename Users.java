public abstract class Users {
    protected String name;
    protected int passportNum, age;

    public Users(){
        this.name = "";
        this.passportNum = 0;
        this.age = 0;
    }
    public Users(String name, int passportNum, int age) {
        this.name = name;
        this.passportNum = passportNum;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }


    public void changeName(String name){
        this.name = name;
    }

    public void changePassportNum(int newPassportNum){
        this.passportNum = newPassportNum;
    }

    public int getAge(){
        return age;
    }

    public abstract String displayInfo();

    public abstract double discPrice();


}