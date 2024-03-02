import java.util.*;
class User{
    private String userName;
    private String userPassword;
    private String userEmail;
    
    public User(String userName,String userPassword,String userEmail){
        this.userName=userName;
        this.userPassword=userPassword;
        this.userEmail=userEmail;
    }
    
    public String getUserName(){
        return userName;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public String getUserEmail(){
        return userEmail;
    }
}

public class Users{
    private List<User> users;

    public Users(){
     users=new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    // public int searchUserByName(String userName){
    //    for(int i=0;i<users.size();i++){
    //     User user=users.get(i);
    //     if(userName == user.getUserName()){
    //         return i;
    //     }
    //    }
    //    return 0;
    // }
    
    public int searchUserByEmail(String userEmail){
        for(int i=0;i<users.size();i++){
            User user=users.get(i);
         if(user.getUserEmail().equals(userEmail)){
             return i;
         }
        }
        return 0;
     }
     
     public boolean searchUserPassword(int i,String password){
        User user=users.get(i);
         if(user.getUserPassword().equals(password)){
             return true;
         }
        return false;
     }
}
