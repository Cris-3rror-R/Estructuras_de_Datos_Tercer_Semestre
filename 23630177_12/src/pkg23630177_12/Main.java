package pkg23630177_12;
import java.util.Scanner;
/**Cristopher Axel Venegas Venegas
 * Implementación de una bicola con Memoria Dinamica
 * Desencola por el frente
 * Encola por el frente o por el final
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble Frente = new Mueble();//Frente apunta al primer elemento de la cola
    static Mueble Final = new Mueble();
    static int TMax=5,Contador=0,ContadorFrente=0;
    public static void InicializaCola(){
        Frente=null; Final=null;
    }
    public static boolean Cola_Vacia(){
        return Frente==null;
    }
    public static boolean Cola_LlenaFrente(){
        return ContadorFrente==0;
    }
    public static boolean Cola_LlenaFinal(){
        return Contador==TMax;
    }
    public static void EncolarFrente(Mueble x){
           x.setProximo(Frente);
           Frente=x;
           Contador++;
           ContadorFrente--;
    }
    public static void EncolarFinal(Mueble x){
        if(Cola_Vacia()){
            Frente=x;
            Final=x;
            Contador++;
        }else{
            Final.setProximo(x);
            Final=x;
            Contador++;
        }
    }
    public static void DesencolarFrente(){
        if(Cola_Vacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Frente.getID()+"\t");
            System.out.print(Frente.getModelo()+"\t");
            System.out.print(Frente.getCantidad()+"\t");
            System.out.print(Frente.getPrecio()+"\t");
            System.out.println(Frente.getTama());
                if(Frente!=Final){
                    Frente=Frente.getProximo();
                }else{
                    InicializaCola();
                }
            Contador--;
            ContadorFrente++;
        }
    }
    public static void Consultar_Cola(){
        if(Cola_Vacia()){
            System.out.println("Cola Vacia.");
        }else{
            Mueble Aux=new Mueble();
            Aux=Frente;
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
        InicializaCola();    
        int op=0;
            while(op!=5){
                System.out.println("1.Encolar por frente 2.Encolar por final 3.Desencolar por frente 4.Consultar elementos de Cola 5.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Encolar por frente");
                            if(Cola_LlenaFrente()){
                                System.out.println("Cola llena por el frente");
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
                                EncolarFrente(x);
                            }
                        break;
                    case 2:System.out.println("Encolar por final");
                            if(Cola_LlenaFinal()){
                                System.out.println("Cola llena por el final");
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
                                EncolarFinal(x);
                            }
                        break;
                    case 3:System.out.println("Desencolar por el frente");
                            DesencolarFrente();
                        break;
                    case 4:System.out.println("Elementos de la cola");
                            Consultar_Cola();
                        break;
                    case 5:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
}
