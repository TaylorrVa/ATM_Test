import java.util.HashMap;



class Admin extends Person {
    private String password;
    private String userName; 
    static HashMap<Integer, User> userInfo = new HashMap<>();
    HashMap<Integer, User> adminInfo = new HashMap<>();

    public Admin(String firstName, String lastName,String userName, String password){
        super(firstName, lastName);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String name){
        this.userName = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public static void addUser(String firstName, String lastName, String userName, String password, int accessNum){
        User user = new User(firstName, lastName, userName, password, accessNum);
        userInfo.put(user.getAccessNum(), user);
    }

    public static String removeUser(int key){
       User user = userInfo.get(key);
       userInfo.remove(user.getAccessNum());
       return user.toString() + ": removed";
    }

    public static User searchUser(int key){
        return userInfo.get(key);
    }

    public static void displayUserInfo(int key){
        User user = userInfo.get(key); 
        System.out.println(user.toString());
    }

    public static User searchName(String fName, String lName){
        for(User i : userInfo.values()){
            String first = i.getFirstName();
            String last = i.getLastName();
            if(first.equalsIgnoreCase(fName) && last.equalsIgnoreCase(lName)){
                return i;
            }
        }
        return null;
    }
    public static void printUsers(){
        for(User i : userInfo.values()){
            int key = i.getAccessNum();
            displayUserInfo(key); 
        }
    }
    
}