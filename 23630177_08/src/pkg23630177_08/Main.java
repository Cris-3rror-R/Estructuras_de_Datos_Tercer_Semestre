package pkg23630177_08;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una cola usando arreglos
 * "Memoria estática"
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] Cola = new Mueble[5];
        static int Frente=-1,Final=-1,TMax=4;
    public static void InicializaCola(){
        for(int x=0;x<=4;x++){
            Cola[x]=new Mueble();
        }
    }
    public static boolean ColaVacia(){
        return Frente==-1;
    }
    public static boolean ColaLlena(){
        return Final==TMax;
    }
    public static void Encolar(Mueble x){
        if(ColaVacia()){
            Frente++;
            Final++;
            Cola[Final]=x;
        }else{
            Final++;
            Cola[Final]=x;
        }
    }
    public static void ReorganizarCola(){
        for(int x=0;x<=Final;x++){
            Cola[x]=Cola[x+1];
        }
    }
    public static void Desencolar(){
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
                Final--;
                ReorganizarCola();
            }else{
                Frente=-1;
                Final=-1;
            }
        }
    }
    public static void ConsultarCola(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
                for(int x=0;x<=Final;x++){
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
            while(op!=4){
                System.out.println("1.Meter(Encolar) 2.Sacar(Desencolar) 3.Consultar elementos de Cola 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Encolar");
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
                                Encolar(x);
                            }
                        break;
                    case 2:System.out.println("Desencolar");
                            Desencolar();
                        break;
                    case 3:System.out.println("Consultar elementos de Cola");
                            ConsultarCola();
                        break;
                    case 4:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
}
