import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ShoppingCart
{
    private ArrayList<Product> compra = new ArrayList();
    public ShoppingCart(){
                
    }
    
    public void addToCart(Product p, int quantity){
        int pos;
        if(compra.contains(p)){
            pos=compra.indexOf(p);
            compra.get(pos).setStock(compra.get(pos).getStock()+quantity);
        }
        else{
            Product newP = new Product(p.getBrand(),p.getPrize(),quantity,p.getId());
            compra.add(newP);
            p.setStock(p.getStock()-quantity);
        }
    }
    
    public void deleteCart(Product p){
        p.setStock(p.getStock()+compra.get(compra.indexOf(p)).getStock());
        compra.remove(p);
    }
    
    public Product getProductById(int id){
        for(Product prod:compra){
            if(prod.getId()==id){
                return prod;
            }
        }        
        return null;
    }
    
    public void showCart(){
        for(Product prod: compra){
            System.out.println(prod.toString());
            System.out.println("Total " + prod.getStock() + " uds = " + prod.getPrize()*prod.getStock() + "€");
            System.out.println("---------------------------");
        }
    }
    
    public double totalCart(){
        double count=0;
        for(Product prod: compra){
            count+=prod.getPrize()*prod.getStock();
        }
        return count;
    }
    
    public void buyCart(){
        compra.clear();
        System.out.println("Se ha realizado la compra exitosamente!\n");
    }
}
