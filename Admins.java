import java.util.*;
class Admin{

private String adminName;
private String adminPassword;

public Admin(String adminName,String adminPassword){
    this.adminName=adminName;
    this.adminPassword=adminPassword;
}

public String getAdminName(){
    return adminName;
}
public String getAdminPassword(){
    return adminPassword;
}
}
public class Admins{
  private List<Admin> admins;

   public Admins(){
    admins=new ArrayList<>();
   }
   
   public void addAdmin(Admin admin){
    admins.add(admin);
   }

   public int searchAdmin(String name){
    for(int i=0;i<admins.size();i++){
        Admin admin=admins.get(i);
        if(admin.getAdminName().equals(name)){
          return i;
        }
    }
    return 0;
   }
   public boolean searchAdminPassword(int i,String s){
    
        Admin admin=admins.get(i);
        if(admin.getAdminPassword().equals(s)) return true;
    return false;
   }

}
