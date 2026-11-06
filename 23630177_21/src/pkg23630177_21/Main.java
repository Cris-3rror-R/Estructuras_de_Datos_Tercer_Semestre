package pkg23630177_21;

import java.util.Scanner;
/**
 * Implementacion de un ARBOL BINARIO con MEMORIA DINAMICA
 * Cristopher Axel Venegas Venegas 3A 
 * Autor del código de insertar:Universidad Politècnica de València-UPV 
 * El algoritmo para insertar por recursividad me base en el siguiente video. 
 * https://www.youtube.com/watch?v=Yy_0EqTpFPs 
 * Lo ajuste para poder implementarlo de forma correcta en el programa.
 * 
 * El algoritmo para eliminar, se uso como referencia el de las notas de clase pero
 * sé adaptado para el uso de recursividad y en memoria dinamica pero tambien me base
 * en el siguiente código para eliminación de un nodo con recursividad.
 * Autor del códgio de eliminar: Parzibyte's blog
 * https://parzibyte.me/blog/2023/01/18/java-eliminar-nodo-arbol-binario-abb/
 * 
 * Los algoritmos de InOrden, PreOrden y PosOrden, se hicieron como referencia a la 
 * clase que el maestro mostro el código de InOrden.
 * Pero para la lógica de los recorridos se uso el siguiente video en los minutos 4:16 a 7:55.
 * Autor del video acerca de los recorridos: Vida MRR - Programacion web
 * https://www.youtube.com/watch?v=tBaOQeyXYqg
 */
public class Main {
    static Scanner sc=new Scanner(System.in);
    static Scanner nc=new Scanner(System.in);
    static Mueble Arbol=new Mueble();

    public static boolean ArbolVacio() {
        return Arbol==null;
    }

    public static void InsertarNodo(Mueble NodoIns) {
        Arbol=Insertar(Arbol,NodoIns);
    }

    public static Mueble Insertar(Mueble Arbol,Mueble NodoIns){
        if(Arbol==null){
            Arbol=NodoIns;
            return Arbol;
        }else{
            if(NodoIns.getID()<Arbol.getID()){
                Arbol.setHijoIzquierdo(Insertar(Arbol.getHijoIzquierdo(),NodoIns));
            }else{
                Arbol.setHijoDerecho(Insertar(Arbol.getHijoDerecho(),NodoIns));
            }
        }
        return Arbol;
    }

    public static void EliminarNodo(String NEli){
        Arbol=Eliminar(Arbol,NEli);
    }

    public static Mueble Eliminar(Mueble Arbol,String NEli){
        if(Arbol==null){
            return Arbol;
        }else{
            if(Arbol.getModelo().equals(NEli)){
                if(Arbol.getHijoIzquierdo()==null){
                    return Arbol.getHijoDerecho();
                }else{
                    if(Arbol.getHijoDerecho()==null){
                        return Arbol.getHijoIzquierdo();
                    }else{
                        Arbol.setID(min(Arbol.getHijoDerecho()));
                        Arbol.setHijoDerecho(Eliminar(Arbol.getHijoDerecho(),NEli));
                    }
                }
            }else{
                Arbol.setHijoIzquierdo(Eliminar(Arbol.getHijoIzquierdo(),NEli));
                Arbol.setHijoDerecho(Eliminar(Arbol.getHijoDerecho(),NEli));
            }
        }
        return Arbol;
    }

    public static int min(Mueble Arbol){
        int HijoMenor = Arbol.getID();
        while(Arbol.getHijoIzquierdo()!=null){
            HijoMenor=Arbol.getHijoIzquierdo().getID();
            Arbol=Arbol.getHijoIzquierdo();
        }
        return HijoMenor;
    }

    public static boolean Buscar(Mueble Arbol,String NEli){
        if(Arbol==null){
            return false;
        }
        if(Arbol.getModelo().equals(NEli)){
            return true;
        }
        boolean RamaIzquierda=Buscar(Arbol.getHijoIzquierdo(),NEli);
        if(RamaIzquierda){
            return true;
        }else{
            return Buscar(Arbol.getHijoDerecho(),NEli);
        }
    }

    public static void InOrden(Mueble Arbol){
        if(Arbol!=null){
            InOrden(Arbol.getHijoIzquierdo());
            System.out.print(Arbol.getID() + "\t");
            System.out.print(Arbol.getModelo() + "\t");
            System.out.print(Arbol.getCantidad() + "\t");
            System.out.print(Arbol.getPrecio() + "\t");
            System.out.println(Arbol.getTama());
            InOrden(Arbol.getHijoDerecho());
        }
    }

    public static void PreOrden(Mueble Arbol) {
        if(Arbol!=null){
            System.out.print(Arbol.getID() + "\t");
            System.out.print(Arbol.getModelo() + "\t");
            System.out.print(Arbol.getCantidad() + "\t");
            System.out.print(Arbol.getPrecio() + "\t");
            System.out.println(Arbol.getTama());
            PreOrden(Arbol.getHijoIzquierdo());
            PreOrden(Arbol.getHijoDerecho());
        }
    }

    public static void PosOrden(Mueble Arbol) {
        if(Arbol!=null){
            PosOrden(Arbol.getHijoIzquierdo());
            PosOrden(Arbol.getHijoDerecho());
            System.out.print(Arbol.getID() + "\t");
            System.out.print(Arbol.getModelo() + "\t");
            System.out.print(Arbol.getCantidad() + "\t");
            System.out.print(Arbol.getPrecio() + "\t");
            System.out.println(Arbol.getTama());
        }
    }

    public static void main(String[] args) {
        Arbol=null;
        int op=0;
        while(op!=4){
            System.out.println("1.Insertar 2.Eliminar 3.Recorrer 4.Terminar");
            op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Insertar");
                    Mueble NodoIns = new Mueble();
                    System.out.println("ID del mueble");
                    NodoIns.setID(sc.nextInt());
                    System.out.println("Nombre del modelo");
                    NodoIns.setModelo(nc.nextLine());
                    System.out.println("Cantidad de inventario");
                    NodoIns.setCantidad(sc.nextInt());
                    System.out.println("Precio del mueble");
                    NodoIns.setPrecio(sc.nextFloat());
                    System.out.println("Dimensiones del mueble");
                    NodoIns.setTama(nc.nextLine());
                    InsertarNodo(NodoIns);
                    break;
                case 2:
                    System.out.println("Eliminar");
                    if(ArbolVacio()){
                        System.out.println("El Arból esta vacio");
                    }else{
                        System.out.println("¿Qué modelo deseas eliminar?");
                        String NEli=nc.nextLine();
                        if(Buscar(Arbol, NEli)){
                            EliminarNodo(NEli);
                            System.out.println("Nodo eliminado.");
                        }else{
                            System.out.println("No existe en el arbol.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Recorrer");
                    if(ArbolVacio()){
                        System.out.println("EL Arból esta vacio");
                    }else{
                        System.out.println("1.InOrden\t 2.PreOrden\t 3.PosOrden");
                        int u=nc.nextInt();
                        switch(u){
                            case 1:
                                System.out.println("InOrden");
                                System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
                                InOrden(Arbol);
                                break;
                            case 2:
                                System.out.println("PreOrden");
                                PreOrden(Arbol);
                                break;
                            case 3:
                                System.out.println("PosOrden");
                                PosOrden(Arbol);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Terminar");
                    break;
                default:
                    break;
            }
        }
    }
}