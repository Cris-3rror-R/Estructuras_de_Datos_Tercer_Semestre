package pkg23630177_15;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista simple "Memoria Dinamica"
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    //Es el inicio de la lista simple
    static Mueble Inicio = new Mueble();
    static Mueble Siguiente = new Mueble();
    public static boolean Lista_Vacia(){
        return Inicio==null;
    }
    public static void Insertar(Mueble x){
        if(Lista_Vacia()){
            Inicio=x;
            Siguiente=x;
        }else{
            Siguiente.setProximo(x);
            Siguiente=x;
        }
    }
    public static Mueble Ultimo(){
        Mueble Ultimo=Inicio;
        while(Ultimo.getProximo()!=null){
            Ultimo=Ultimo.getProximo();
        }
        return Ultimo;
    }
    public static Mueble Anterior(Mueble a){
        Mueble Aux=Inicio;
        Mueble Ant=null;
        while(Aux!=null&&!Aux.getModelo().equals(a.getModelo())){
            Ant=Aux;
            Aux=Aux.getProximo();
        }
        return Ant;
    }
    public static Mueble Buscar(String a){
        Mueble Aux=Inicio;
            while((Aux!=null)){
                if(Aux.getModelo().equals(a)){
                   return Aux;
                }
                Aux=Aux.getProximo(); 
        }
            return null;
    }
    public static void Eliminar(){
        if(Lista_Vacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("Ingrese el nombre del modelo a eliminar");
                String a=nc.nextLine();
                Mueble Aux=Buscar(a);
                    if(Aux!=null){
                        System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
                        System.out.print(Aux.getID()+"\t");
                        System.out.print(Aux.getModelo()+"\t");
                        System.out.print(Aux.getCantidad()+"\t");
                        System.out.print(Aux.getPrecio()+"\t");
                        System.out.println(Aux.getTama());
                            if(Aux==Inicio){
                                Inicio=Inicio.getProximo();
                            }else{
                                if(Aux==Ultimo()){
                                    Anterior(Aux).setProximo(null);
                                    Siguiente=Anterior(Aux);
                                }else{
                                    Anterior(Aux).setProximo(Aux.getProximo());
                                }
                            }
                        }else{
                        System.out.println("No existe");
                    }
        }
    }
    public static void Recorrer(){
        if(Lista_Vacia()){
            System.out.println("Lista Vacia.");
        }else{
            Mueble Aux=new Mueble();
            Aux=Inicio;
            System.out.println("ID \tModelo \tCant \tPrecio \tTam \tProximo");
                while(Aux!=null){
                    System.out.print(Aux.getID()+"\t");
                    System.out.print(Aux.getModelo()+"\t");
                    System.out.print(Aux.getCantidad()+"\t");
                    System.out.print(Aux.getPrecio()+"\t");
                    System.out.print(Aux.getTama()+"\t");
                        if(Aux.getProximo()==null){
                           System.out.println(Aux.getProximo());
                        }else{
                            System.out.println(Aux.getProximo().getModelo());
                        }
                        Aux=Aux.getProximo();
                }
        }
    }
    public static void main(String[] args) {
        Inicio=null;
        Siguiente=null;    
        int op=0;
            while(op!=4){
                System.out.println("1.Insertar 2.Eliminar 3.Recorrer 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1: System.out.println("Insertar");
                                Mueble x=new Mueble();
                            System.out.println("ID del mueble");
                                x.setID(sc.nextInt());
                            System.out.println("Nombre del modelo");
                                x.setModelo(nc.nextLine());
                            System.out.println("Cantidad de inventario");
                                x.setCantidad(sc.nextInt());
                            System.out.println("Precio del mueble");
                                x.setPrecio(sc.nextFloat());
                            System.out.println("Dimensiones del mueble");
                                x.setTama(nc.nextLine());
                                    Insertar(x);
                        break;
                    case 2:System.out.println("Eliminar");
                            Eliminar();
                        break;
                    case 3:System.out.println("Recorrer");
                            Recorrer();
                        break;
                    case 4:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
}
