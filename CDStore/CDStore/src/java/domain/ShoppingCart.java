
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import service.Product;
/**
 *
 * @author Fan
 */
public class ShoppingCart {
    Map items = null;
    private int subtotal = 0;
    
    public ShoppingCart(){
        items = new HashMap();
    }

    public void addProductToCart(Product product) {
        items.put(product.getCdid(), product);
    }

    public void removeProductFromCart(String productId) {
        items.remove(productId);
    }

    public ArrayList getAllProductsFromCart() {
        ArrayList<Product> cart_item = new ArrayList<Product>();
        Set itemIdSet = this.items.keySet();
        Iterator it = itemIdSet.iterator();
        subtotal = 0;
        
        while(it.hasNext()){
            String id = (String)it.next();
            Product product = (Product)items.get(id);
            cart_item.add(product);
            subtotal += product.getPrice();
        }
        return cart_item;
    }
    
    public int getSubtotal(){
        return this.subtotal;
    }
}
