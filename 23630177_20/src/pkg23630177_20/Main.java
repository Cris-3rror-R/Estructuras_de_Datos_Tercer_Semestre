package pkg23630177_20;
import java.util.Scanner;
import java.util.r
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista circular "Memoria estática"
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] ListaCircular = new Mueble[5];
        static int Inicio=-1,Final=-1,TMax=5;
        
    public static void InicializaCola(){
        for(int x=0;x<=4;x++){
            ListaCircular[x]=new Mueble();
        }
    }
    public static boolean ListaVacia(){
        return Inicio==-1;
    }
    public static boolean ListaLlena(){
        return Disponible()==-1;
    }
    public static int Buscar(String a){
        int Aux=0;
            for(int x=0;x<TMax;x++){
                if(ListaCircular[x].getModelo().equals(a)){
                    return Aux;
                }
                    Aux++;
            }
            return -1;
    }
    public static int Disponible(){
        for (int x=0;x<TMax;x++) {
            if(ListaCircular[x].getModelo().equals("*")){
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
                Final++;
                ListaCircular[Final]=x;
                ListaCircular[Final].setIzquierda(x.getModelo());
                ListaCircular[Final].setDerecha(x.getModelo());
            }else{
                System.out.println("En que elemento de referencia?");
                String a=nc.nextLine();
                int ER=Buscar(a);
                    if(ER!=-1){
                        System.out.println("1.Izquieda\t 2.Derecha");
                            int op=sc.nextInt();
                            int Espacio=Disponible();
                                if(Espacio!=-1){
                                    switch(op){
                                case 1:
                                    System.out.println("Izquierda");
                                        if(ER==Inicio){
                                            ListaCircular[Espacio]=x;
                                            ListaCircular[Espacio].setDerecha(ListaCircular[Inicio].getModelo());
                                            ListaCircular[Espacio].setIzquierda(ListaCircular[Final].getModelo());
                                            ListaCircular[Inicio].setIzquierda(ListaCircular[Espacio].getModelo());
                                            ListaCircular[Final].setDerecha(ListaCircular[Espacio].getModelo());
                                            Inicio=Espacio;
                                        }else{
                                            int Izquierda=Buscar(ListaCircular[ER].getIzquierda());
                                            ListaCircular[Espacio]=x;
                                            ListaCircular[Espacio].setIzquierda(ListaCircular[Izquierda].getModelo());
                                            ListaCircular[Espacio].setDerecha(ListaCircular[ER].getModelo());
                                            ListaCircular[Izquierda].setDerecha(ListaCircular[Espacio].getModelo());
                                            ListaCircular[ER].setIzquierda(ListaCircular[Espacio].getModelo());
                                            ListaCircular[Espacio]=x;
                                         }
                                    break;
                                case 2:
                                    System.out.println("Derecha");
                                    int Derecha=Buscar(ListaCircular[ER].getDerecha());
                                        ListaCircular[Espacio]=x;
                                        ListaCircular[Espacio].setIzquierda(ListaCircular[ER].getModelo());
                                        ListaCircular[Espacio].setDerecha(Derecha!=-1?ListaCircular[Derecha].getModelo():ListaCircular[Inicio].getModelo());
                                        ListaCircular[ER].setDerecha(ListaCircular[Espacio].getModelo());
                                    if(Derecha!=-1){
                                        ListaCircular[Derecha].setIzquierda(ListaCircular[Espacio].getModelo());
                                    }else{
                                        ListaCircular[Espacio].setDerecha(ListaCircular[Espacio].getModelo());
                                    }
                                    if(ER==Final){
                                        Final=Espacio;
                                }   
                                    break;
                                default:
                                    break;
                        }
                                }
                    }else{
                        System.out.println("No existe.");
                    }
            }
        }
    }
    public static void Eliminar() {
        if(ListaVacia()){
            System.out.println("Lista vacía.");
        }else{
            System.out.println("Ingrese el modelo de referencia:");
            String a=nc.nextLine();
            int Aux=Buscar(a);
            if(Aux!=-1){
                System.out.println("1. Izquierda\t 2. Derecha");
                int b=sc.nextInt();
                    switch(b){
                        case 1:
                            System.out.println("Izquierda");
                            if(Aux==Inicio){
                                System.out.println("No se puede eliminar porque está vacío el campo Izquierda.");
                            }else{
                                int Izquierda=Buscar(ListaCircular[Aux].getIzquierda());
                                System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                System.out.print(ListaCircular[Izquierda].getIzquierda()+"\t");
                                System.out.print(ListaCircular[Izquierda].getID()+"\t");
                                System.out.print(ListaCircular[Izquierda].getModelo()+"\t");
                                System.out.print(ListaCircular[Izquierda].getCantidad()+"\t");
                                System.out.print(ListaCircular[Izquierda].getPrecio()+"\t");
                                System.out.print(ListaCircular[Izquierda].getTama()+'\t');
                                System.out.println(ListaCircular[Izquierda].getDerecha());
                                int IzquierdaDeIzquierda=Buscar(ListaCircular[Izquierda].getIzquierda());
                                ListaCircular[Aux].setIzquierda(ListaCircular[Izquierda].getIzquierda());
                                ListaCircular[IzquierdaDeIzquierda].setDerecha(ListaCircular[Aux].getModelo());
                                ListaCircular[Izquierda].setModelo("*");    
                        }
                            break;
                        case 2:
                            System.out.println("Derecha");
                            if(Aux==Final){
                                System.out.println("No se puede eliminar porque está vacío el campo Derecha.");
                        }else{
                            int Derecha=Buscar(ListaCircular[Aux].getDerecha());
                            System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                            System.out.print(ListaCircular[Derecha].getIzquierda()+"\t");
                            System.out.print(ListaCircular[Derecha].getID()+"\t");
                            System.out.print(ListaCircular[Derecha].getModelo()+"\t");
                            System.out.print(ListaCircular[Derecha].getCantidad()+"\t");
                            System.out.print(ListaCircular[Derecha].getPrecio()+"\t");
                            System.out.print(ListaCircular[Derecha].getTama()+'\t');
                            System.out.println(ListaCircular[Derecha].getDerecha());
                            int DerechaDeDerecha=Buscar(ListaCircular[Derecha].getDerecha());
                            ListaCircular[Aux].setDerecha(ListaCircular[Derecha].getDerecha());
                            ListaCircular[DerechaDeDerecha].setIzquierda(ListaCircular[Aux].getModelo());
                            ListaCircular[Derecha].setModelo("*");
                    }
                    break;
                default:
                    break;
            }
            if(Inicio==Aux&&Final==Aux) {
                Inicio=-1;
                Final=-1;
            }else{
                ListaCircular[Inicio].setIzquierda(ListaCircular[Final].getModelo());
                ListaCircular[Final].setDerecha(ListaCircular[Inicio].getModelo());
            }
            }else{
                System.out.println("No existe.");
            }
        }
    }
    public static void Recorrer(){
        if(ListaVacia()){
            System.out.println("Lista Vacia");
            Inicio=0;
        }else{
            System.out.println("Ingrese un modelo de referencia");
            String h=nc.nextLine();
            int Aux=Buscar(h);
                if(Aux!=-1){
                   System.out.println("1.Derecha\t  2.Izquierda");
                   int a=sc.nextInt(); 
                        switch(a){
                            case 1:
                                System.out.println("Derecha");
                                System.out.println("Der\tID \tModelo \tCant \tPrecio \tTamaño \tIzq");
                                String c=ListaCircular[Aux].getModelo();
                                int j=Aux;
                                    do{
                                        if(!"*".equals(ListaCircular[j].getModelo())){
                                            System.out.print(ListaCircular[j].getDerecha()+"\t");
                                            System.out.print(ListaCircular[j].getID()+"\t");
                                            System.out.print(ListaCircular[j].getModelo()+"\t");
                                            System.out.print(ListaCircular[j].getCantidad()+"\t");
                                            System.out.print(ListaCircular[j].getPrecio()+"\t");
                                            System.out.print(ListaCircular[j].getTama()+'\t');
                                            System.out.println(ListaCircular[j].getIzquierda());
                                        }
                                        j++;
                                        if(j==TMax){
                                            j=0;
                                        }
                                        c=ListaCircular[j].getModelo();
                                    }while(!c.equals(h));
                                break;
                            case 2:
                                System.out.println("Izquierda");
                                System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                String b=ListaCircular[Aux].getModelo();
                                int i=Aux;
                                    do{
                                        if(!"*".equals(ListaCircular[i].getModelo())){
                                            System.out.print(ListaCircular[i].getIzquierda()+"\t");
                                            System.out.print(ListaCircular[i].getID()+"\t");
                                            System.out.print(ListaCircular[i].getModelo()+"\t");
                                            System.out.print(ListaCircular[i].getCantidad()+"\t");
                                            System.out.print(ListaCircular[i].getPrecio()+"\t");
                                            System.out.print(ListaCircular[i].getTama()+'\t');
                                            System.out.println(ListaCircular[i].getDerecha());
                                        }
                                        i--;
                                            if(i==-1){
                                                i=TMax-1;
                                            }
                                        b=ListaCircular[i].getModelo();
                                    }while(!b.equals(h));
                                break;
                        }
                }else{
                    System.out.println("No existe");
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
