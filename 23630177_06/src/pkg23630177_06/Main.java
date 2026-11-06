package pkg23630177_06;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una pila 
 * "Memoria Dinamica"
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble Pila = new Mueble();
    static Mueble Cima= new Mueble();
    static int tamPila=10,contador=0;
    
    public static boolean Pila_Vacia(){
        return Pila==null;
    }
    public static boolean Pila_Llena(){
        return contador==tamPila;
    }
    public static Mueble Anterior(){
        Mueble aux=Pila;
        Mueble ant=Pila;
            while(aux.getProximo()!=null){
                    ant=aux;
                    aux=aux.getProximo();
                }
            return ant;
    }
    public static void Meter(Mueble x){
        if(Pila_Vacia()){
            Pila=x;
            Cima=x;
            contador++;
        }else{
            Cima.setProximo(x);
            Cima=x;
            contador++;
        }
    }
    public static void SacarPila(){
        if(Pila_Vacia()){
            System.out.println("Pila Vacia.");
        }else if(Cima==Pila){
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Cima.getID()+"\t");
            System.out.print(Cima.getModelo()+"\t");
            System.out.print(Cima.getCantidad()+"\t");
            System.out.print(Cima.getPrecio()+"\t");
            System.out.println(Cima.getTama());
                contador--;
                Pila=null;
                Cima=null;
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Cima.getID()+"\t");
            System.out.print(Cima.getModelo()+"\t");
            System.out.print(Cima.getCantidad()+"\t");
            System.out.print(Cima.getPrecio()+"\t");
            System.out.println(Cima.getTama());
            Cima=Anterior();
            Cima.setProximo(null);
            contador--;
        }
    }
    public static void Vaciar_Pila(){
        if(Pila_Vacia()){
            System.out.println("Pila Vacia.");
        }else{
            Mueble Aux=new Mueble();
            Aux=Pila;
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
                System.out.println("Cima="+Cima.getModelo());
        }
    }
    public static void main(String[] args) {
        Cima=null;Pila=null;//Inicializa pila    
        int op=0;
            while(op!=4){
                System.out.println("1.Meter(Push) 2.Sacar(Pop) 3.Vaciar Pila 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Meter");
                            if(Pila_Llena()){
                                System.out.println("Pila llena");
                            }else{
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
                                Meter(x);
                            }
                        break;
                    case 2:System.out.println("Sacar");
                            SacarPila();
                        break;
                    case 3:System.out.println("Vaciar Pila");
                        Vaciar_Pila();
                        break;
                    case 4:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
}
