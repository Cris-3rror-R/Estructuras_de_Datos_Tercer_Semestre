package pkg23630177_17;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista doble "Memoria Dinamica"
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble Inicio = new Mueble();
    public static boolean Lista_Vacia(){
        return Inicio==null;
    }
    public static void Insertar(Mueble x){
        if(Lista_Vacia()){
            Inicio=x;
        }else{
            System.out.println("En que elemento de referencia");
            String a=nc.nextLine();
                Mueble ER=Buscar(a);
                if(ER==null){
                    System.out.println("No existe");
                }else{
                    System.out.println("En que direccion vas a insertar");
                    System.out.println("1.Izquierda            2.Derecha");
                        int ele=sc.nextInt();
                    switch(ele){
                        case 1:
                                if(ER==Inicio){
                                    Inicio.setIzquierda(x);
                                    x.setDerecha(Inicio);
                                    Inicio=x;
                                }else{
                                    x.setIzquierda(ER.getIzquierda());
                                    x.setDerecha(ER);
                                    ER.getIzquierda().setDerecha(x);
                                    ER.setIzquierda(x);
                                }
                            break;
                        case 2:
                                if(ER==Ultimo()){
                                    x.setIzquierda(ER);
                                    x.setDerecha(null);
                                    ER.setDerecha(x);
                                }else{
                                    if(ER==Inicio){
                                        x.setIzquierda(Inicio);
                                        x.setDerecha(Inicio.getDerecha());
                                        Inicio.getDerecha().setIzquierda(x);
                                        Inicio.setDerecha(x);
                                    }else{
                                        x.setIzquierda(ER);
                                        x.setDerecha(ER.getDerecha());
                                        ER.getDerecha().setIzquierda(x);
                                        ER.setDerecha(x); 
                                    }
                                }
                            break;
                    }
                }
        }
    }
    public static Mueble Ultimo(){
        Mueble Ultimo=Inicio;
        while(Ultimo.getDerecha()!=null){
            Ultimo=Ultimo.getDerecha();
        }
        return Ultimo;
    }
    public static Mueble Buscar(String a){
        Mueble Aux=Inicio;
            while((Aux!=null)){
                if(Aux.getModelo().equals(a)){
                   return Aux;
                }
                Aux=Aux.getDerecha(); 
        }
            return null;
    }
    public static void Eliminar(){
        if(Lista_Vacia()){
            System.out.println("Lista Vacia.");
        }else{
            System.out.println("Ingrese el nombre del modelo a eliminar");
                String a=nc.nextLine();
                Mueble EE=Buscar(a);
                    if(EE!=null){
                        if(Inicio.getDerecha()==null&&Inicio.getDerecha()==null){
                           System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer"); 
                           System.out.print("null\t");
                           System.out.print(EE.getID()+"\t");
                           System.out.print(EE.getModelo()+"\t");
                           System.out.print(EE.getCantidad()+"\t");
                           System.out.print(EE.getPrecio()+"\t");
                           System.out.print(EE.getTama()+"\t");
                           System.out.println("null\t");
                           Inicio=null;
                        }else{
                            System.out.println("1.Izquierda\t2.Derecha");
                        int op=sc.nextInt();
                            switch(op){
                                case 1:
                                    EE=EE.getIzquierda();
                                        if(EE!=null){
                                            System.out.println("Izquierda");
                                            System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                        if(EE.getIzquierda()==null){
                                            System.out.print("null\t");
                                        }else{
                                            System.out.print(EE.getIzquierda().getModelo()+"\t");
                                        }
                                        System.out.print(EE.getID()+"\t");
                                        System.out.print(EE.getModelo()+"\t");
                                        System.out.print(EE.getCantidad()+"\t");
                                        System.out.print(EE.getPrecio()+"\t");
                                        System.out.print(EE.getTama()+"\t");
                                            if(EE.getDerecha()==null){
                                                System.out.println("null");
                                        }else{
                                            System.out.println(EE.getDerecha().getModelo());
                                        }
                                        if(EE==Inicio){
                                            Inicio=EE.getDerecha();
                                        if(Inicio!=null){
                                            Inicio.setIzquierda(null);
                                        }
                                    }else{
                                        if(EE==Ultimo()){
                                        EE.getIzquierda().setDerecha(null);
                                    }else{
                                        EE.getIzquierda().setDerecha(EE.getDerecha());
                                        EE.getDerecha().setIzquierda(EE.getIzquierda());
                                        }
                                    }      
                                        }else{
                                            System.out.println("No se puede eliminar debido que es NULL");  
                                        }
                                    break;
                                case 2:
                                        EE=EE.getDerecha();
                                        if(EE!=null){
                                            System.out.println("Derecha");
                                            System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                        if(EE.getIzquierda()==null){
                                            System.out.print("null\t");
                                        }else{
                                            System.out.print(EE.getIzquierda().getModelo()+"\t");
                                        }
                                        System.out.print(EE.getID()+"\t");
                                        System.out.print(EE.getModelo()+"\t");
                                        System.out.print(EE.getCantidad()+"\t");
                                        System.out.print(EE.getPrecio()+"\t");
                                        System.out.print(EE.getTama()+"\t");
                                            if(EE.getDerecha()==null){
                                                System.out.println("null");
                                        }else{
                                            System.out.println(EE.getDerecha().getModelo());
                                        }
                                        if(EE==Inicio){
                                            Inicio=EE.getDerecha();
                                        if(Inicio!=null){
                                            Inicio.setIzquierda(null);
                                        }
                                    }else{
                                        if(EE==Ultimo()){
                                        EE.getIzquierda().setDerecha(null);
                                    }else{
                                        EE.getIzquierda().setDerecha(EE.getDerecha());
                                        EE.getDerecha().setIzquierda(EE.getIzquierda());
                                        }
                                    }      
                                        }else{
                                            System.out.println("No se puede eliminar debido que es NULL");  
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
    public static void Recorrer(){
        if(Lista_Vacia()){
            System.out.println("Lista Vacia.");
        }else{
            Mueble Aux=new Mueble();
            System.out.println("Por donde deseas recorrer la lista");
            System.out.println("1.Derecha                2.Izquierda");
            int ele=sc.nextInt();
                switch(ele){
                    case 1:
                        System.out.println("Derecha");
                            Aux=Inicio;
                            System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                while(Aux!=null){
                                    if(Aux.getIzquierda()==null){
                                        System.out.print(Aux.getIzquierda()+"\t");
                                    }else{
                                        System.out.print(Aux.getIzquierda().getModelo()+"\t");
                                    }
                                    System.out.print(Aux.getID()+"\t");
                                    System.out.print(Aux.getModelo()+"\t");
                                    System.out.print(Aux.getCantidad()+"\t");
                                    System.out.print(Aux.getPrecio()+"\t");
                                    System.out.print(Aux.getTama()+"\t");
                                        if(Aux.getDerecha()==null){
                                            System.out.println("null");
                                        }else{
                                            System.out.println(Aux.getDerecha().getModelo());
                                            }
                                                Aux=Aux.getDerecha();
                                    }
                                break;
                    case 2:
                        System.out.println("Izquierda");
                            Aux=Ultimo();
                            System.out.println("Der \tID \tModelo \tCant \tPrecio \tTamaño \tIzq");
                                while(Aux!=null){
                                    if(Aux.getDerecha()==null){
                                        System.out.print(Aux.getDerecha()+"\t");
                                    }else{
                                        System.out.print(Aux.getDerecha().getModelo()+"\t");
                                    }
                                    System.out.print(Aux.getID()+"\t");
                                    System.out.print(Aux.getModelo()+"\t");
                                    System.out.print(Aux.getCantidad()+"\t");
                                    System.out.print(Aux.getPrecio()+"\t");
                                    System.out.print(Aux.getTama()+"\t");
                                        if(Aux.getIzquierda()==null){
                                            System.out.println("null");
                                        }else{
                                            System.out.println(Aux.getIzquierda().getModelo());
                                            }
                                                Aux=Aux.getIzquierda();
                                    }
                        break;
                    default:
                        break;
            }
        }
    }

    public static void main(String[] args) {
        Inicio=null;
                
        int op=0;
            while(op!=4){
                System.out.println("1.Insertar 2.Eliminar 3.Recorrer 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1: System.out.println("Insertar");
                                Mueble EI=new Mueble();
                            System.out.println("ID del mueble");
                                EI.setID(sc.nextInt());
                            System.out.println("Nombre del modelo");
                                EI.setModelo(nc.nextLine());
                            System.out.println("Cantidad de inventario");
                                EI.setCantidad(sc.nextInt());
                            System.out.println("Precio del mueble");
                                EI.setPrecio(sc.nextFloat());
                            System.out.println("Dimensiones del mueble");
                                EI.setTama(nc.nextLine());
                                    Insertar(EI);
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
