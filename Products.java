import java.util.ArrayList;
import java.util.List;

class Product{
    private String name;
    private int quantity;
    private double cost;
    public Product(String name, int quantity, double cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getquantity() {
        return quantity;
    }

    public double getcost() {
        return cost;
    }

    public void setquantity(int quantity){
    this.quantity=quantity;
    }

    public void setprice(int cost){
        this.cost=cost;
        }
}
public class Products{
   private List<Product> products;

   public Products(){
    products=new ArrayList<>();
   }

   
   public void addProduct(Product product){
    products.add(product);
   }

   public void removeProduct(int pId) 
   {
     for (int i=0;i<products.size();i++) 
      {
         if (i == pId) 
         {
            products.remove(i);
            break;
         }
      }
    }

    public void changeQuantityByAdmin(int pId,int quantity){
      Product product=products.get(pId);
      product.setquantity(quantity);
    }

    public void changeCostByAdmin(int pId,int cost){
        Product product=products.get(pId);
        product.setprice(cost);
      }

    public void displayAllProductsForAdmins() {
        System.out.println("Product_Id     Product_Name        Product_Quantity  Product_Cost");
        System.out.println("*********************************************************************");
        for (int i=0;i<products.size();i++) {//prod 15 name 20 quant 18 cost 15
            Product p=products.get(i);
            String id=String.format("%-15d",i );
            String name=String.format("%-20s", p.getName());
            String quantity=String.format("%-18d", p.getquantity());
            String cost=String.format("%-15.2f", p.getcost());
            System.out.println(id+name+quantity+cost);
        }
        System.out.println("*********************************************************************");
    }
                                                                  
    public void displayAllTheCartItems(List<CartItem> items){
        System.out.println("Product_Id     Product_Name          No_of_Items    Product_Cost");
        System.out.println("*********************************************************************");
        for (CartItem item:items) {//prod 15 name 20 quant 18 cost 15 
            int i=item.getProductId();
            Product p=products.get(i);
           String id=String.format("%-15d",i );
            String name=String.format("%-20s", p.getName());
            String quantity=String.format("%-18d", item.getProductQuantity());
            String cost=String.format("%-15.2f", p.getcost());
            System.out.println(id+name+quantity+cost);
        }
        System.out.println("*********************************************************************");
    }
    
    public double displayTotalCostOfSelectedProducts(List<CartItem> items){
        double sum=0;
        for (int i=0;i<items.size();i++) {
            CartItem item=items.get(i);
            Product p=products.get(item.getProductId());
            sum+=(p.getcost()*item.getProductQuantity());           
        }
        return sum;
    }


    public void changedQuantityByUser(int pid, int quantity) {
        Product product=products.get(pid);
        product.setquantity(product.getquantity()-quantity);
    }


    public void addQuantityByUser(int pid1, int quantity2) {
        Product product=products.get(pid1);
        product.setquantity(product.getquantity()+quantity2);
    }
}