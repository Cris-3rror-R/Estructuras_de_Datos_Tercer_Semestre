package pkg23630177_16;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista simple "Memoria estática"
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] ListaSimple = new Mueble[5];
        static int Inicio=-1,Siguiente=-1,TMax=5;
        
    public static void InicializaCola(){
        for(int x=0;x<=4;x++){
            ListaSimple[x]=new Mueble();
        }
    }
    public static boolean ListaVacia(){
        return Inicio==-1;
    }
    public static boolean ListaLlena(){
        return Siguiente==TMax-1;
    }
    public static int Disponible(int a){
        for (int x=0;x<=a;x++) {
            if(ListaSimple[x].getModelo().equals("*")){
                return x;
            }
        }
        return -1;
    }
    public static void Insertar(Mueble x){
        if (ListaLlena()){
            System.out.println("Lista llena");
        }else{
            if(ListaVacia()){
                Inicio++;
                Siguiente++;
                ListaSimple[Siguiente]=x;
                ListaSimple[Siguiente].setProximo(0);
            }else{
                int Espacio=Disponible(Siguiente);
                    if(Espacio!=-1){
                        ListaSimple[Espacio]=x;
                        ListaSimple[Espacio].setProximo(Espacio);
                    }else{
                        Siguiente++;
                        ListaSimple[Siguiente]=x;
                        ListaSimple[Siguiente].setProximo(Siguiente);
                        ListaSimple[Siguiente-1].setProximo(Siguiente-1);
                }
            }
        }
    }
    public static int Buscar(String a){
        int Aux=0;
            for(int x=0;x<=Siguiente;x++){
                if(ListaSimple[x].getModelo().equals(a)){
                    return Aux;
                }
                    Aux++;
            }
            return -1;
    }
    public static void Eliminar(){
        if(ListaVacia()){
            System.out.println("Lista Vacia.");
        }else{
            System.out.println("Ingrese el modelo a eliminar");
                String a=nc.nextLine();
                int Aux=Buscar(a);
            if(Aux!=-1){
                System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
                System.out.print(ListaSimple[Aux].getID()+"\t");
                System.out.print(ListaSimple[Aux].getModelo()+"\t");
                System.out.print(ListaSimple[Aux].getCantidad()+"\t");
                System.out.print(ListaSimple[Aux].getPrecio()+"\t");
                System.out.println(ListaSimple[Aux].getTama());
                    for(int x=Aux;x<Siguiente;x++){
                            ListaSimple[x]=ListaSimple[x+1];
                        }
                    Siguiente--;
                    if(Siguiente==-1){
                        Inicio=-1;
                    }
                }else{
                System.out.println("No existe.");
            }
        }
    }
    public static void Recorrer(){
        if(ListaVacia()){
            System.out.println("Lista Vacia.");
        }else{
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño \tProximo");
                for(int x=0;x<=Siguiente;x++){
                    if(!"*".equals(ListaSimple[x].getModelo())){
                        System.out.print(ListaSimple[x].getID()+"\t");
                        System.out.print(ListaSimple[x].getModelo()+"\t");
                        System.out.print(ListaSimple[x].getCantidad()+"\t");
                        System.out.print(ListaSimple[x].getPrecio()+"\t");
                        System.out.print(ListaSimple[x].getTama()+"\t");
                        System.out.println(ListaSimple[x].getProximo()); 
                    }
            }
        }
    }
    public static void main(String[] args) {
           InicializaCola();
            int op=0;
            while(op!=4){
                System.out.println("1.Insertar 2.Eliminar 3.Recorrer 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Insertar");
                            if(ListaLlena()){
                                System.out.println("Lista llena");
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
                                Insertar(x);
                            }
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
