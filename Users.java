public abstract class Users {
    protected String name;
    protected int passportNum;

    public Users(){
        this.name = "";
        this.passportNum = 0;
    }
    public Users(String name, int passportNum) {
        this.name = name;
        this.passportNum = passportNum;
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
}