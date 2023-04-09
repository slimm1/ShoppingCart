package ListasBucles;

public class Product
{
    private String brand;
    private double prize;
    private int stock;
    int id;
    public Product(String brand, double prize, int stock, int id){
        this.brand=brand;
        this.prize=prize;
        this.stock=stock;
        this.id=id;
    }

    public void setStock(int newStock){
        this.stock=newStock;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public int getId(){
        return id;
    }
    
    public double getPrize(){
        return prize;
    }
    
    public int getStock(){
        return stock;
    }
    
    public boolean equals(Object other){
        if(other==null){return false;}
        if(!(other instanceof Product)){return false;}
        Product p = (Product) other;
        if(p.getBrand().equalsIgnoreCase(brand) && p.getPrize()==prize){return true;}
        return false;
    }
    
    public String reWrite(){
        StringBuilder output = new StringBuilder();
        output.append(brand+"/"+prize+"/"+stock);
        return output.toString();
    }
    
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("ID --> " + id);
        output.append(" Nombre del producto --> " + brand);
        output.append(System.getProperty("line.separator"));
        output.append("Precio unitario --> " + prize + "€");
        return output.toString();
    }
}
