
import java.util.ArrayList;
public class Stock
{
    private ArrayList<Ordenadores> pcList = new ArrayList(); 
    private String[][]myList = {{"HP","1200","3"},{"ASUS","1199.99","4"},{"ACER","1457.21","8"},{"MSI","999.89","6"},{"LENOVO","789.00","5"}};
    public Stock(){
        

    }
    
    public void addPcToList(){
        for(int row=0; row<myList.length; row++){
            for(int pos = 0; pos<Integer.parseInt((myList[row][2])); pos++){
                 pcList.add(new Ordenadores(myList[row][0], Float.parseFloat(myList[row][1])));
            }
        }
    }
    
    public int countByModel(String answer){
        int count=0;
        for(Ordenadores pc: pcList){
            if(pc.getModel().equalsIgnoreCase(answer)){
                count++;
            }
        }
        return count;
    }
    
    public float totalPrize(){
        float count=0;
        for(Ordenadores pc: pcList){
            count+=pc.getPrize();
        }
        return count;
    }
    
    public float totalPrize(String model){
        float count=0;
        for(Ordenadores pc: pcList){
            if(pc.getModel().equalsIgnoreCase(model)){count+=pc.getPrize();}
        }
        return count;
    }
    
    public void showList(){
        for(Ordenadores pc: pcList){
            System.out.println(pc.toString());
            System.out.println("--------------------------------");
        }
    }
}
