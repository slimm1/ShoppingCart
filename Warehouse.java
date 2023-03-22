import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class Warehouse{
    private ArrayList<Product> warehouse = new ArrayList();
    private int idProd=1;
    String name;
    public Warehouse(String name){
        this.name=name;
        loadData();
    }

    public void loadData(){
        try{
            File input = new File("D:/MARTIN RAMONDA DAM/PROG/FICHEROS/TiendaOnline/products.txt");
            Scanner read = new Scanner(input);
            String brand;
            double prize;
            int stock,pos;
            String[] line;     
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                brand = line[0];
                prize = Double.parseDouble(line[1]);
                stock = Integer.parseInt(line[2]);
                Product newP = new Product(brand,prize,stock,idProd);
                if(warehouse.contains(newP)){
                    pos=warehouse.indexOf(newP);
                    (warehouse.get(pos)).setStock((warehouse.get(pos).getStock())+stock);
                }
                else{
                    idProd++;
                    warehouse.add(newP);
                }
            }
            read.close();
        }
        catch(FileNotFoundException ex){
            System.out.println(">>>>>>>>>>>>>>>>>>>>> Error de lectura de datos <<<<<<<<<<<<<<<<<<<<<");
        }
    }
    
    public Product getProductById(int id){
        for(Product prod:warehouse){
            if(prod.getId()==id){
                return prod;
            }
        }        
        return null;
    }
    
    public void showStock(){
        for(Product prod:warehouse){
            System.out.println(prod.toString());
            if(prod.getStock()==0){
                System.out.println("AGOTADO");
                System.out.println("---------------------------");                
            }
            else{
                System.out.println("Stock ---> " + prod.getStock());
                System.out.println("---------------------------");
            }
        }
    }
    
    public void saveData(){
        try{
            File output = new File("D:/MARTIN RAMONDA DAM/PROG/FICHEROS/TiendaOnline/products.txt");
            PrintWriter pw = new PrintWriter(output);
            for(Product prod:warehouse){
                pw.println(prod.reWrite());
            }
            pw.close();
        }
        catch(FileNotFoundException ex){
            System.out.println(">>>>>>>>>>>>>>>>>>>>> Error de escritura de datos <<<<<<<<<<<<<<<<<<<<<");
        }
    }
}
