import java.util.*;
class CartItem{
    int pid;
    int quantity;

    public CartItem(int pid,int quantity){
      this.pid=pid;
      this.quantity=quantity;
    }

    public int getProductId(){
        return pid;
    }

    public int getProductQuantity(){
        return quantity;
    }

    public void setProductQuantity(int quantity){
        this.quantity=quantity;
    }

}
public class ShoppingCart {
  public List<CartItem> items;

    public ShoppingCart(){
        items=new ArrayList<>();
    }


    public void addToCart(CartItem item){
     items.add(item);
    } 
    
    public List<CartItem> getList(){
       return items;
    }
    
    public int getListSize(){
        return items.size();
     }

    public int removeCartItemByUser(int pid){
        int quantity=0;
     for(int i=0;i<items.size();i++){
        CartItem item=items.get(i);
        if(item.getProductId()==pid) {
            quantity=item.getProductQuantity();
            items.remove(i);
        }
     }
     return quantity;
    }

    public void show(){
        for(CartItem item:items){
            System.out.println("pId: "+item.getProductId()+" pquant: "+item.getProductQuantity());
        }
    }
}
