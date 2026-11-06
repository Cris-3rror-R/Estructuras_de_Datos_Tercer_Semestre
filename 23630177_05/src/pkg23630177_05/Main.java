package pkg23630177_05;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una pila usando arreglos
 * "Memoria estática"
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble[] Pila = new Mueble[10];
    static int Cima=-1,tamPila=10;
    
    public static void Inicializa_Pila(){
        for(int x=0;x<tamPila;x++){
            Pila[x]=new Mueble();
        }
    }
    public static boolean Pila_Vacia(){
        return Cima==-1;
    }
    public static boolean Pila_Llena(){
        return Cima==9;
    }
    public static void Meter(Mueble x){
        Cima++;
        Pila[Cima]=x;
    }
    public static void SacarPila(){
        if(Pila_Vacia()){
            System.out.println("Pila Vacia.");
        }else{
            System.out.println("Pos \tID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Cima+"\t");
            System.out.print(Pila[Cima].getID()+"\t");
            System.out.print(Pila[Cima].getModelo()+"\t");
            System.out.print(Pila[Cima].getCantidad()+"\t");
            System.out.print(Pila[Cima].getPrecio()+"\t");
            System.out.println(Pila[Cima].getTama());
            Cima--;
            
        }
    }
    public static void Vaciar_Pila(){
        if(Pila_Vacia()){
            System.out.println("Pila Vacia.");
        }else{
            System.out.println("Pos \tID \tModelo \tCant \tPrecio \tTamaño");
                for(int x=0;x<=Cima;x++){
                    System.out.print(x+"\t");
                    System.out.print(Pila[x].getID()+"\t");
                    System.out.print(Pila[x].getModelo()+"\t");
                    System.out.print(Pila[x].getCantidad()+"\t");
                    System.out.print(Pila[x].getPrecio()+"\t");
                    System.out.println(Pila[x].getTama());
            }
                System.out.println("Cima ="+Cima);
        }
    }
    public static void main(String[] args) {
            Inicializa_Pila();
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
