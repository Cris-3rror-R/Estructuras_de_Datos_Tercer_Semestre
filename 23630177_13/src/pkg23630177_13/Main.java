package pkg23630177_13;
import java.util.Scanner;
/*
 Cristopher Axel Venegas Venegas
 * Implementación de una cola circular con
 * Memoria Estatica
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] Cola = new Mueble[3];
        static int Frente=-1,Final=0,Anterior=0,Aux=0,TMax=3,TamCola=0;
    public static void InicializaCola(){
        for(int x=0;x<TMax;x++){
            Cola[x]=new Mueble();
        }
    }
    public static boolean ColaVacia(){
        return TamCola==0;
    }
     public static boolean ColaLlena(){
        return TamCola==TMax;
    }
    public static void Encolar(Mueble x){
        if(Frente==-1){
           Frente++;
           Cola[Final]=x;
           Cola[Final].setProximo(Cola[Frente].getModelo());
           Final++;
           TamCola++;
        }else{
            Anterior=Final-1;
            if(Anterior==-1){
                Anterior=TMax-1;
            }
            if(Frente!=0){
                Cola[Final]=x;
                Cola[Anterior].setProximo(Cola[Final].getModelo());
                int proximo=Final+1;
                Cola[Final].setProximo(Cola[proximo].getModelo());
                Final++;
                int m=0;
                while(TamCola>m){
                    proximo=m+1;
                        if(proximo==TamCola){
                            break;
                        }else{
                            Cola[m].setProximo(Cola[proximo].getModelo()); 
                        }
                        m++;
                }
                Cola[Final].setProximo(Cola[proximo].getModelo());
                Final++;
                if(Final==TMax){
                    Anterior=Final-1;
                    Cola[Anterior].setProximo(Cola[Frente].getModelo());
                    Final=0;
                }
            }else{
                Cola[Final]=x;
            Cola[Anterior].setProximo(Cola[Final].getModelo());
                Final++;
                if(Final==TMax){
                    Anterior=Final-1;
                    Cola[Anterior].setProximo(Cola[Frente].getModelo());
                    Final=0;
                }
            }
            TamCola++;
        }
    }
    public static void Desencolar(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño \tProximo");
                System.out.print(Cola[Frente].getID()+"\t");
                System.out.print(Cola[Frente].getModelo()+"\t");
                System.out.print(Cola[Frente].getCantidad()+"\t");
                System.out.print(Cola[Frente].getPrecio()+"\t");
                System.out.print(Cola[Frente].getTama()+"\t");
                System.out.println(Cola[Frente].getProximo());
                    TamCola--;
                    Aux=Frente+1;
                        if(Aux==TMax){
                            Aux=0;
                        }
                        Cola[Aux].setProximo(Cola[Final].getModelo());
                            Frente++;
                            if(Frente==TMax){
                                Cola[Aux].setProximo(Cola[Final].getModelo());
                                Frente=0;
                            }
        }
    }
    public static int Buscar(String Busqueda){
        int cont=-1,existe=0;
        for(int x=0;x<TamCola+1;x++) {
            cont++;
            if(Busqueda.equals(Cola[x].getModelo())) {
               existe++;
             break;
            }
        }
        if(existe==1){
            return cont;
        }else{
            return -1;
        }
    }
    public static void ConsultarCola(){
        if(ColaVacia()){
            System.out.println("Cola Vacia.");
        }else{
            System.out.println("A partir de que modelo");
            String Busqueda = nc.nextLine();
            int Inicio=Buscar(Busqueda);
                if(Inicio!=-1){
                    System.out.println("ID \tModelo \tCant \tPrecio \tTamaño \tProximo");
                    int c=0,n=Inicio;
                    while(TamCola>c){
                        if(c==0){
                            System.out.print(Cola[n].getID()+"\t");
                            System.out.print(Cola[n].getModelo()+"\t");
                            System.out.print(Cola[n].getCantidad()+"\t");
                            System.out.print(Cola[n].getPrecio()+"\t");
                            System.out.print(Cola[n].getTama()+"\t");
                            System.out.println(Cola[n].getProximo());
                            n++;
                        }else{
                            if(Frente!=0){
                                if(Frente-1==n){
                                    n++;
                                }else{
                                    System.out.print(Cola[n].getID()+"\t");
                                    System.out.print(Cola[n].getModelo()+"\t");
                                    System.out.print(Cola[n].getCantidad()+"\t");
                                    System.out.print(Cola[n].getPrecio()+"\t");
                                    System.out.print(Cola[n].getTama()+"\t");
                                    System.out.println(Cola[n].getProximo());
                                    n++;
                                }
                                }else{
                                    System.out.print(Cola[n].getID()+"\t");
                                    System.out.print(Cola[n].getModelo()+"\t");
                                    System.out.print(Cola[n].getCantidad()+"\t");
                                    System.out.print(Cola[n].getPrecio()+"\t");
                                    System.out.print(Cola[n].getTama()+"\t");
                                    System.out.println(Cola[n].getProximo());
                                n++;    
                            }
                        }
                        if(n==TMax){
                            n=0;
                        }
                        c++;
                    }
                }else{
                    System.out.println("No existe ese modelo");
                }
            }
    }
    public static void main(String[] args) {
    InicializaCola();
        int op=0;
            while(op!=4){
                System.out.println("1.Meter 2.Sacar 3.Consultar elementos de Cola 4.Terminar");
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
