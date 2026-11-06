package pkg23630177_19;
import java.util.Scanner;
/**
 Cristopher Axel Venegas Venegas
 * Implementación de una lista circular "Memoria Dinamica"
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
            Inicio.setIzquierda(x);
            Inicio.setDerecha(x);
        }else{
            System.out.println("En que elemento de referencia");
            String a=nc.nextLine();
                Mueble ER=Buscar(a);
                if(ER==null){
                    System.out.println("No existe");
                }else{
                    System.out.println("En que direccion vas a insertar");
                    System.out.println("1.Izquierda\t2.Derecha");
                        int ele=sc.nextInt();
                    switch(ele){
                        case 1:
                                if(ER==Inicio){
                                    x.setDerecha(Inicio);
                                    x.setIzquierda(Inicio.getIzquierda());
                                    Inicio.getIzquierda().setDerecha(x);
                                    Inicio.setIzquierda(x);
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
                                    x.setDerecha(Inicio);
                                    ER.setDerecha(x);
                                    Inicio.setIzquierda(x);
                                }else{
                                    if(ER==Inicio){
                                        x.setIzquierda(Inicio);
                                        x.setDerecha(Inicio.getDerecha());
                                        ER.setDerecha(x);
                                        Inicio.setIzquierda(x);
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
        while(Ultimo.getDerecha()!=Inicio){
            Ultimo=Ultimo.getDerecha();
        }
        return Ultimo;
    }
    public static Mueble Buscar(String a){
        Mueble Aux=Inicio;
        do{
             if(Aux.getModelo().equals(a)){
                   return Aux;
                }
             Aux=Aux.getDerecha();
        }while(Aux!=Inicio);
            return null;
    }
    public static void Eliminar(){
        if(Lista_Vacia()){
            System.out.println("Lista Vacia.");
        }else{
            System.out.println("Ingrese el nombre del modelo de referencia");
                String a=nc.nextLine();
                Mueble EE=Buscar(a);
                    if(EE!=null){
                        System.out.println("1.Izquierda\t2.Derecha");
                        int op=sc.nextInt();
                            switch(op){
                                case 1:
                                    System.out.println("Izquierda");
                                    EE=EE.getIzquierda();
                                        System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                        System.out.print(EE.getIzquierda().getModelo()+"\t");
                                        System.out.print(EE.getID()+"\t");
                                        System.out.print(EE.getModelo()+"\t");
                                        System.out.print(EE.getCantidad()+"\t");
                                        System.out.print(EE.getPrecio()+"\t");
                                        System.out.print(EE.getTama()+"\t");
                                        System.out.println(EE.getDerecha().getModelo());
                                            if(EE==Inicio){
                                                Inicio=EE.getDerecha();
                                                Inicio.setIzquierda(Ultimo()); 
                                                Ultimo().setDerecha(Inicio);
                                            }else{
                                            if(EE==Ultimo()){
                                                EE.getIzquierda().setDerecha(Inicio);
                                                Inicio.setIzquierda(EE.getIzquierda());
                                            }else{
                                                EE.getIzquierda().setDerecha(EE.getDerecha());
                                                EE.getDerecha().setIzquierda(EE.getIzquierda());
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Derecha");
                                    EE=EE.getDerecha();
                                        System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                                        System.out.print(EE.getIzquierda().getModelo()+"\t");
                                        System.out.print(EE.getID()+"\t");
                                        System.out.print(EE.getModelo()+"\t");
                                        System.out.print(EE.getCantidad()+"\t");
                                        System.out.print(EE.getPrecio()+"\t");
                                        System.out.print(EE.getTama()+"\t");
                                        System.out.println(EE.getDerecha().getModelo());
                                            if(EE==Inicio){
                                                Inicio=EE.getDerecha();
                                                Inicio.setIzquierda(Ultimo()); 
                                                Ultimo().setDerecha(Inicio);
                                            }else{
                                            if(EE==Ultimo()){
                                                EE.getIzquierda().setDerecha(Inicio);
                                                Inicio.setIzquierda(EE.getIzquierda());
                                            }else{
                                                EE.getIzquierda().setDerecha(EE.getDerecha());
                                                EE.getDerecha().setIzquierda(EE.getIzquierda());
                                        }
                                    }
                                    break;
                                default:
                                    break;
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
            System.out.println("Desde que elemento deseas recorrer la lista?");
            String a=nc.nextLine();
            Mueble Aux=Buscar(a),EB=Aux;
                if(Aux==null){
                    System.out.println("No existe");
                }else{
                    System.out.println("Por donde deseas recorrer la lista");
            System.out.println("1.Derecha                2.Izquierda");
            int ele=sc.nextInt();
                switch(ele){
                    case 1:
                        System.out.println("Derecha");
                            System.out.println("Izq \tID \tModelo \tCant \tPrecio \tTamaño \tDer");
                            do{
                                System.out.print(Aux.getIzquierda().getModelo()+"\t");
                                System.out.print(Aux.getID()+"\t");
                                System.out.print(Aux.getModelo()+"\t");
                                System.out.print(Aux.getCantidad()+"\t");
                                System.out.print(Aux.getPrecio()+"\t");
                                System.out.print(Aux.getTama()+"\t");
                                System.out.println(Aux.getDerecha().getModelo());
                                    Aux=Aux.getDerecha();
                            }while(Aux!=EB);
                                break;
                    case 2:
                        System.out.println("Izquierda");
                            System.out.println("Der \tID \tModelo \tCant \tPrecio \tTamaño \tIzq");
                            do{
                                System.out.print(Aux.getDerecha().getModelo()+"\t");
                                System.out.print(Aux.getID()+"\t");
                                System.out.print(Aux.getModelo()+"\t");
                                System.out.print(Aux.getCantidad()+"\t");
                                System.out.print(Aux.getPrecio()+"\t");
                                System.out.print(Aux.getTama()+"\t");
                                System.out.println(Aux.getIzquierda().getModelo());
                                    Aux=Aux.getIzquierda();
                            }while(Aux!=EB);
                                break;
                    default:
                        break;
            }
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
