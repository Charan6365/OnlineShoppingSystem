import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Admins admins=new Admins();
        Products products=new Products();
        Users users=new Users();
        ShoppingCart cart=new ShoppingCart();



        //Pre Loaded data of the products
        products.addProduct(new Product("HP-AE12", 100, 25000));
        products.addProduct(new Product("DELL", 100, 35000));
        products.addProduct(new Product("ASUS", 100, 28000));
        products.addProduct(new Product("APPLE", 100, 59000));
        products.addProduct(new Product("ACER", 100, 23000));
        products.addProduct(new Product("SAMSUNG", 100, 35000));
        products.addProduct(new Product("OPPO", 100,14000 ));
        products.addProduct(new Product("XAOMI", 100, 44000));
        products.addProduct(new Product("HUAWEI", 100, 19000));
        products.addProduct(new Product("VIVO", 100, 11000));

        //Pre Loaded Admins data as admins can not be added in normal way[ the acc name is :"Satyacharan" and password is :"12345"]
        admins.addAdmin(new Admin("Satyacharan","12345" ));

        //Pre Loaded Users data for  the login use.
        users.addUser(new User("Satyacharan", "12345", "satyacharan9595@gmail.com"));
        

   while(true){
    System.out.println("Welcome to the OnlineStore");
    System.out.print("Enter 'a' for Admins OR 'u' for Users: ");
    String utiliser=sc.nextLine();
    boolean flag=false,temp=false;
    if("a".equals(utiliser)){
     flag=true;
    }
    else if("u".equals(utiliser)){
    temp=true;
    }
    else{
        System.out.println("Enter correctly!");
    }


    while(flag){
    System.out.print("\nEnter you name(As per your user_name): ");
    String name1=sc.nextLine();
    System.out.print("\nEnter your password: ");
    String password=sc.nextLine();
    if(admins.searchAdminPassword(admins.searchAdmin(name1),password)){
           while(flag){
           System.out.println("*************************************");
           System.out.println("1.Display Inventory");
           System.out.println("2.Add Product");
           System.out.println("3.Remove Product");
           System.out.println("4.Logout from you account");
           System.out.println("*************************************");
           System.out.print("Enter your option number: ");
           int num=sc.nextInt();
           sc.nextLine();
           switch (num) {
            case 1:{
                products.displayAllProductsForAdmins();
                break;
            }
           
            case 2:{
                System.out.print("\nEnter the name of the Product: ");
                String name2=sc.nextLine();
                System.out.print("\nEnter the quantity of Product: ");
                int quantity1=sc.nextInt();
                sc.nextLine();
                System.out.print("\nEnter the Cost of the Product: ");
                double cost1=sc.nextDouble();
                products.addProduct(new Product(name2, quantity1, cost1));
                System.out.println("Product Added.");
                break;
            }
                
                
            case 3:{
                System.out.print("\nEnter the product_id to remove: ");
                int pid1=sc.nextInt();
                sc.nextLine();
                products.removeProduct(pid1);
                System.out.println("Removed product!");
                break;
            }
                
                
            case 4:{
                flag=false;
                break;
            }
            default:{
                System.out.println("Choose correct option!");
            }
           }
           }
    }
    else{
        System.out.println("Incorrect name or password. Try again!");
    }
    }



    while(temp){
      System.out.print("\nEnter 'in' for Login if already have an account( or )Enter 'c' for creating a new account: ");
      String userType=sc.nextLine();
      boolean temp1=false;
      if("in".equals(userType)){
       System.out.print("\nEnter your Email_Id: ");
       String email=sc.nextLine();
       System.out.print("\nEnter your password: ");
       String password=sc.nextLine();
         if(users.searchUserPassword(users.searchUserByEmail(email), password)){
           temp1=true;
         }
         else{
           System.out.println("Incorrect Email_Id or password. Try again!");
         }
      }
      else if("c".equals(userType)){
         System.out.print("Enter your name: ");
         String name3=sc.nextLine();
         System.out.print("\nEnter your password: ");
         String password=sc.nextLine();
         System.out.print("\nEnter your Email_Id: ");
         String email=sc.nextLine();
         users.addUser(new User(name3, password, email));
         System.out.println("Account created!");
         temp1=true;
      }
      else{
        System.out.println("Enter correctly!");
      }

      while(temp && temp1){
            System.out.println("*************************************");
            System.out.println("1.Display Products Available");
            System.out.println("2.Buy Product");
            System.out.println("3.View the Cart_Items");
            System.out.println("4.Remove Product from the Cart");
            System.out.println("5.Total Cost of the Products in Cart");
            System.out.println("6.Place Order");
            System.out.println("7.Logout from you account and discard the Cart");
            System.out.println("*************************************");
            System.out.print("Enter your option number: ");
            int num=sc.nextInt();
            sc.nextLine();
            switch (num) {
             case 1:{
                 products.displayAllProductsForAdmins();
                 break;
             }
            
             case 2:{
                 System.out.print("\nEnter the Product_Id: ");
                 int pid=sc.nextInt();
                 sc.nextLine();
                 System.out.print("\nEnter number of pieces you want: ");
                 int quantity1=sc.nextInt();
                 cart.addToCart(new CartItem(pid, quantity1));
                 products.changedQuantityByUser(pid, quantity1);
                 System.out.println("Product Added.");
                 break;
             }
                 
                 
             case 3:{
                products.displayAllTheCartItems(cart.getList());
                break;
             }
                 
                 
             case 4:{
                System.out.print("\nEnter the product_id to remove from the cart: ");
                int pid1=sc.nextInt();
                sc.nextLine();
                int quantity2=cart.removeCartItemByUser(pid1);
                products.addQuantityByUser(pid1,quantity2);
                 break;
             }
             case 5:{
                System.out.println("\nThe TotalCost of the products in the cart: "+products.displayTotalCostOfSelectedProducts(cart.getList()));
                break;
             }
             case 6:{
              System.out.println("Order placed!\n Order will be delivered to your Address.");
              break;
             }
             case 7:{
                temp1=false;
                break;
             }
             default:{
                 System.out.println("Choose correct option!");
             }
            }
            
      }

    System.out.print("Want to Exit from the Sign_In Page? if so type \"yes\" or else type any character: ");
    String decision=sc.nextLine();
    if(decision.equals("yes")) temp=false;
    }


    System.out.print("Want to exit from the Application? if so type \"yes\" or else type any character:");
    String decision=sc.nextLine();
    if(decision.equals("yes")) break;

   }

  System.out.println("Exited!");
  sc.close();
    }
}
