package pkg23630177_10;
import java.util.Scanner;
/*
 Cristopher Axel Venegas Venegas
 * Implementación de bicola Memoria Estática
 * Entrada restringidad - Solo encola por el Final
 * Salida por Frente o Final
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] Cola = new Mueble[5];
        static int Frente=0,Final=0,TMax=5;
    public static void InicializaCola(){
        for(int x=0;x<TMax;x++){
            Cola[x]=new Mueble();
        }
    }
    public static boolean ColaVacia(){
        return Frente==Final;
    }
     public static boolean ColaLlena(){
        return Final==TMax;
    }
    public static void EncolarFinal(Mueble x){
            Cola[Final]=x;
            Final++;
    }
    public static void DesencolarFrente(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Cola[Frente].getID()+"\t");
            System.out.print(Cola[Frente].getModelo()+"\t");
            System.out.print(Cola[Frente].getCantidad()+"\t");
            System.out.print(Cola[Frente].getPrecio()+"\t");
            System.out.println(Cola[Frente].getTama());
            if(Final!=Frente){
                Frente++;
            }else{
                Final=0;
                Frente=0;
            }
        }
    }
    public static void DesencolarFinal(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            if(Final!=Frente){
                Final--;
            }else{
                Final=0;
                Frente=0;
            }
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Cola[Final].getID()+"\t");
            System.out.print(Cola[Final].getModelo()+"\t");
            System.out.print(Cola[Final].getCantidad()+"\t");
            System.out.print(Cola[Final].getPrecio()+"\t");
            System.out.println(Cola[Final].getTama());
        }
    }
    public static void ConsultarCola(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
                for(int x=Frente;x<Final;x++){
                    System.out.print(Cola[x].getID()+"\t");
                    System.out.print(Cola[x].getModelo()+"\t");
                    System.out.print(Cola[x].getCantidad()+"\t");
                    System.out.print(Cola[x].getPrecio()+"\t");
                    System.out.println(Cola[x].getTama());
            }
        }
    }
    public static void main(String[] args) {
    InicializaCola();
        int op=0;
            while(op!=5){
                System.out.println("1.Meter(Encolar Final) 2.Sacar(Desencolar Frente) 3.Sacar(Desencolar Final) 4.Consultar elementos de Cola 5.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Encolar por el Final");
                            if(ColaLlena()){
                                System.out.println("Cola llena");
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
                    case 2:System.out.println("Desencolar por el Frente");
                            DesencolarFrente();
                        break;
                    case 3:System.out.println("Desencolar por el Frente");
                            DesencolarFinal();
                        break;
                    case 4:System.out.println("Consultar elementos de Cola");
                            ConsultarCola();
                        break;
                    case 5:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
    
}
