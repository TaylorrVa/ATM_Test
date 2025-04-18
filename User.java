public class User extends Person {
    private int pin;
    private int accessNum;
    private String userName;
    private String password;

    public User(String firstName, String lastName, String userName, String password, int accessNum) {
        super(firstName, lastName);
        this.userName = userName;
        this.password = password;
        this.accessNum = accessNum;
        this.pin = 1111;
        
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public int getAccessNum(){
        return accessNum;
    }

    public int getPin(){
        return pin;
    }

    public void setUsername(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void setAccessNum(int accessNum){
        this.accessNum = accessNum;
    }
    
    @Override
    public String toString(){
        return "User{" + getFirstName() + ", " + getLastName() + ", " + String.valueOf(accessNum) +", " + userName + ", " + password + ", " + String.valueOf(pin);
    }

}

