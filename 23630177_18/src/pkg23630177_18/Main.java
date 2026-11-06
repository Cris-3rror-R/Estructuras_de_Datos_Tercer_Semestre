package pkg23630177_18;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista doble "Memoria estática"
 */
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Scanner nc = new Scanner(System.in);
        static Mueble[] ListaDoble = new Mueble[5];
        static int Inicio=-1,Final=-1,TMax=5;
        
    public static void InicializaCola(){
        for(int x=0;x<=4;x++){
            ListaDoble[x]=new Mueble();
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
                if(ListaDoble[x].getModelo().equals(a)){
                    return Aux;
                }
                    Aux++;
            }
            return -1;
    }
    public static int Disponible(){
        for (int x=0;x<TMax;x++) {
            if(ListaDoble[x].getModelo().equals("*")){
                return x;
            }
        }
        return -1;
    }
    public static void Insertar(Mueble x) {
        if(ListaLlena()){
            System.out.println("Lista llena");
        }else{
            if(ListaVacia()){
                Inicio++;
                Final++;
                ListaDoble[Final]=x;
            }else{
                System.out.println("En que modelo a insertar");
                String a=nc.nextLine();
                int ER=Buscar(a);
                if(ER!=-1){
                    System.out.println("1.Izquierda\t 2.Derecha");
                    int op=sc.nextInt();
                    int Espacio=Disponible();
                    if(Espacio!=-1){
                        switch(op){
                            case 1:
                                System.out.println("Izquierda");
                                    if(ER==Inicio){
                                        ListaDoble[Espacio]=x;
                                        ListaDoble[Espacio].setDerecha(ListaDoble[Inicio].getModelo());
                                        ListaDoble[Inicio].setIzquierda(ListaDoble[Espacio].getModelo());
                                        Inicio=Espacio;
                                    }else{
                                        int Izquierda=Buscar(ListaDoble[ER].getIzquierda());
                                        ListaDoble[Espacio]=x;
                                        ListaDoble[Espacio].setIzquierda(ListaDoble[Izquierda].getModelo());
                                        ListaDoble[Espacio].setDerecha(ListaDoble[ER].getModelo());
                                        ListaDoble[Izquierda].setDerecha(ListaDoble[Espacio].getModelo());
                                        ListaDoble[ER].setIzquierda(ListaDoble[Espacio].getModelo());
                                    }
                            break;
                        case 2:
                            System.out.println("Derecha");
                                if(ER==Final){
                                    ListaDoble[Espacio]=x;
                                    ListaDoble[Espacio].setIzquierda(ListaDoble[Final].getModelo());
                                    ListaDoble[Final].setDerecha(ListaDoble[Espacio].getModelo());
                                    Final=Espacio;
                                }else{
                                    int Derecha =Buscar(ListaDoble[ER].getDerecha());
                                    ListaDoble[Espacio] = x;
                                    ListaDoble[Espacio].setIzquierda(ListaDoble[ER].getModelo());
                                    ListaDoble[Espacio].setDerecha(ListaDoble[Derecha].getModelo());
                                    ListaDoble[ER].setDerecha(ListaDoble[Espacio].getModelo());
                                    ListaDoble[Derecha].setIzquierda(ListaDoble[Espacio].getModelo());
                                }
                            break;
                        default:
                            break;
                        }
                    }
                }else{
                System.out.println("No existe");
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
            if(Aux!=-1) {
                if(Aux==Inicio&&!"*".equals(ListaDoble[Inicio].getIzquierda())&&!"*".equals(ListaDoble[Inicio].getDerecha())) {
                    System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                    System.out.print(ListaDoble[Aux].getID() + "\t");
                    System.out.print(ListaDoble[Aux].getModelo() + "\t");
                    System.out.print(ListaDoble[Aux].getCantidad() + "\t");
                    System.out.print(ListaDoble[Aux].getPrecio() + "\t");
                    System.out.print(ListaDoble[Aux].getTama() + "\t");
                    System.out.println(ListaDoble[Aux].getDerecha());
                    ListaDoble[Aux].setModelo("*");
                    Inicio=-1;
            }else{
                System.out.println("1.Izquierda\t  2.Derecha");
                int b=sc.nextInt();
                switch(b){
                    case 1:
                        System.out.println("Izquierda");
                        if(Aux==Inicio) {
                            System.out.println("No se puede eliminar porque está vacío el campo Izquierda.");
                        }else{
                            int Izquierda = Buscar(ListaDoble[Aux].getIzquierda());
                            int Derecha = Buscar(ListaDoble[Izquierda].getDerecha());
                            System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                            System.out.print(ListaDoble[Izquierda].getID() + "\t");
                            System.out.print(ListaDoble[Izquierda].getModelo() + "\t");
                            System.out.print(ListaDoble[Izquierda].getCantidad() + "\t");
                            System.out.print(ListaDoble[Izquierda].getPrecio() + "\t");
                            System.out.print(ListaDoble[Izquierda].getTama() + "\t");
                            System.out.println(ListaDoble[Izquierda].getDerecha());
                            ListaDoble[Aux].setIzquierda(ListaDoble[Izquierda].getIzquierda());
                            ListaDoble[Derecha].setDerecha(ListaDoble[Aux].getIzquierda());
                            ListaDoble[Izquierda].setModelo("*");
                        }
                        break;
                    case 2:
                        System.out.println("Derecha");
                        if(Aux==Final){
                            System.out.println("No se puede eliminar porque está vacío el campo Derecha.");
                        }else{
                            int Derecha=Buscar(ListaDoble[Aux].getDerecha());
                            int Izquierda=Buscar(ListaDoble[Derecha].getIzquierda());
                            System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                            System.out.print(ListaDoble[Derecha].getID() + "\t");
                            System.out.print(ListaDoble[Derecha].getModelo() + "\t");
                            System.out.print(ListaDoble[Derecha].getCantidad() + "\t");
                            System.out.print(ListaDoble[Derecha].getPrecio() + "\t");
                            System.out.print(ListaDoble[Derecha].getTama() + "\t");
                            System.out.println(ListaDoble[Derecha].getDerecha());
                            if (Derecha == Final) {
                                ListaDoble[Aux].setDerecha("-1");
                            } else {
                                ListaDoble[Aux].setDerecha(ListaDoble[Derecha].getDerecha());
                                ListaDoble[Izquierda].setIzquierda(ListaDoble[Aux].getDerecha());
                                ListaDoble[Derecha].setModelo("*");
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                    }
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
            System.out.println("1.Inicio a Fin\t  2.Fin a Inicio");
            int a=sc.nextInt();
                switch(a){
                    case 1:
                        System.out.println("Inicio a Fin");
                        System.out.println("Izq\tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                            String Aux=ListaDoble[Inicio].getModelo();
                            int j=Inicio;
                            while(!"-1".equals(Aux)){
                                if(!"*".equals(ListaDoble[j].getModelo())){
                                    System.out.print(ListaDoble[j].getIzquierda()+"\t");
                                    System.out.print(ListaDoble[j].getID()+"\t");
                                    System.out.print(ListaDoble[j].getModelo()+"\t");
                                    System.out.print(ListaDoble[j].getCantidad()+"\t");
                                    System.out.print(ListaDoble[j].getPrecio()+"\t");
                                    System.out.print(ListaDoble[j].getTama()+"\t");
                                    System.out.println(ListaDoble[j].getDerecha());
                                }
                                Aux=ListaDoble[j].getDerecha();
                                j=Buscar(Aux);
                            }    
                            break;
                    case 2:
                        System.out.println("Fin a Inicio");
                        System.out.println("Der\t ID \tModelo \tCant \tPrecio \tTamaño \tIzq");
                            String AuxDos=ListaDoble[Final].getModelo();
                            int i=Final;
                            while(!"-1".equals(AuxDos)){
                                if(!"*".equals(ListaDoble[i].getModelo())){
                                    System.out.print(ListaDoble[i].getDerecha()+"\t");
                                    System.out.print(ListaDoble[i].getID()+"\t");
                                    System.out.print(ListaDoble[i].getModelo()+"\t");
                                    System.out.print(ListaDoble[i].getCantidad()+"\t");
                                    System.out.print(ListaDoble[i].getPrecio()+"\t");
                                    System.out.print(ListaDoble[i].getTama()+"\t");
                                    System.out.println(ListaDoble[i].getIzquierda());
                                }
                                AuxDos=ListaDoble[i].getIzquierda();
                                i=Buscar(AuxDos);
                            }
                        break;
                    default:
                    break;
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
