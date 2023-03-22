import java.util.Scanner;
public class Interface
{
    static Scanner sc = new Scanner(System.in);
    static Warehouse w = new Warehouse("Badulake");
    static ShoppingCart carrito = new ShoppingCart();
    public static void main(String[]Args){
        menuPrincipal();
    }
    
    private static void menuPrincipal(){
        System.out.println(" ".repeat(15)+"  \\\\ EL BADULAKE ON-LINE ////");
        System.out.println(" ".repeat(15)+" >>>  NUESTROS PRODUCTOS  <<<  ");
        System.out.println();
        w.showStock();
        System.out.println("\n¿Qué deseas hacer?\n");
        System.out.print("1.- COMPRAS     2.- SALIR");
        interaccionPrincipal();
    }
    
    private static void interaccionPrincipal(){
        int answer;
        answer=toInt(sc.nextLine());
        while(answer<1||answer>2){
            System.out.println("No entiendo");
            answer=toInt(sc.nextLine());
        }
        if(answer==1){
            menuCompra();
        }
        else if(answer==2){
            System.out.println("¡Hasta pronto!");
            sc.close();
        }
    }
    
    private static void menuCompra(){
        int id, uds;
        System.out.print("Introduce el ID del producto para añadirlo al carrito: ");
        id=toInt(sc.nextLine());
        while(w.getProductById(id)==null||w.getProductById(id).getStock()==0){
            if(w.getProductById(id)==null){
                System.out.print("Artículo no encontrado");
                id=toInt(sc.nextLine());
            }
            else{
                System.out.print("Artículo agotado");
                id=toInt(sc.nextLine());                
            }
        }
        System.out.print(w.getProductById(id).getBrand() + " --> ¿Cuántas unidades quieres?");
        uds=toInt(sc.nextLine());
        while(uds>w.getProductById(id).getStock() || uds<=0){
            System.out.print("Cantidad errónea, el stock es de " + w.getProductById(id).getStock());
            uds=toInt(sc.nextLine());
        }
        carrito.addToCart(w.getProductById(id), uds);
        System.out.println("¡Producto añadido con éxito!");
        bucleCompra();
    }
    
    private static void bucleCompra(){
        System.out.println("\n¿Qué deseas hacer?\n");
        System.out.println("1.- SEGUIR COMPRANDO     2.- VER CARRITO      3.- ELIMINAR PRODUCTOS DEL CARRITO     4.-PROCEDER CON EL PAGO     5.-SALIR");
        int answer;
        answer=toInt(sc.nextLine());
        while(answer<1||answer>5){
            System.out.println("No entiendo");
            answer=toInt(sc.nextLine());
        }
        navegador(answer);
    }
    
    private static void navegador(int answer){
        switch(answer){
            case 1:
                 menuCompra();
                 break;
            case 2:
                 carrito.showCart();
                 System.out.println("\nTotal carrito = " + carrito.totalCart());
                 bucleCompra();
                 break;
            case 3:
                deleteCarrito();
                bucleCompra();
                break;
            case 4:
                compra();
                break;
            case 5: 
                System.out.println("Hasta la vista!");
                sc.close();
                break;
        }
    }
    
    private static void deleteCarrito(){
        int id, uds;
        System.out.print("Introduce el ID del producto para borrarlo del carrito: ");
        id=toInt(sc.nextLine());
        while(carrito.getProductById(id)==null){
            System.out.println("Artículo no encontrado");
            id=toInt(sc.nextLine());
        }
        carrito.deleteCart(w.getProductById(id));
        System.out.println("El producto se ha borrado del carrito exitosamente");        
    }
    
    private static void compra(){
        String answer;
        System.out.print("¿Proceder con el pago? ---> ENTER para continuar, cualquier otro para cancelar");
        answer=sc.nextLine();
        if(answer.isBlank()){
            w.saveData();
            carrito.buyCart();
            System.out.println("GRACIAS POR SU COMPRA\n");
            menuPrincipal();
        }
        else{
            bucleCompra();
        }
    }
    
    private static boolean fullInt(String respuesta){
        for(int pos=0; pos<respuesta.length(); pos++){
            if(!(Character.isDigit(respuesta.charAt(pos)) || (respuesta.charAt(pos)=='-' && pos==0))){
                return false;
            }
        }
        return true;
    }

    private static int toInt(String respuesta){
        while(!fullInt(respuesta) || respuesta.isBlank()){
            System.out.println("El número introducido no es correcto");
            respuesta=sc.nextLine();
        }
        int numero=Integer.valueOf(respuesta);
        return numero;
    }
}
