public class Kid extends Users{

    private String parentName;

    public Kid(String name, int passportNum, String parentName){
        super(name, passportNum);
        this.parentName = parentName;
    }

    public String getParentName(){
        return this.parentName;
    }

    public void changeParentName(String newParentName){
        this.parentName = newParentName;
    }

    
}