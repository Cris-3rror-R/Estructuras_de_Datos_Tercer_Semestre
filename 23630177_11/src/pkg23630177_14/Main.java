package pkg23630177_14;

import java.util.Scanner;

/**
 * Cristopher Axel Venegas Venegas Implementación de una cola circular con
 * Memoria Dinamica
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble Frente = new Mueble();
    static Mueble Final = new Mueble();
    static int TMax = 10;

    public static void InicializaCola() {
        Frente = null;
        Final = null;
    }
    public static boolean Cola_Vacia() {
        return Frente == null;
    }
    public static int TamCola() {
        Mueble Aux = Frente;
        int Tam = 0;
        if (Frente != null) {
            while (Aux != Final) {
                Tam++;
                Aux = Aux.getProximo();
            }
            Tam++;
        }
        return Tam;
    }
    public static boolean Cola_Llena() {
        return TamCola() == TMax;
    }
    public static Mueble Anterior() {
        Mueble Aux = Frente;
        Mueble Ant = null;
        while (Aux.getProximo() != null) {
            Ant = Aux;
            Aux = Aux.getProximo();
        }
        return Ant;
    }
    public static void Encolar(Mueble x) {
        if (Cola_Vacia()) {
            x.setProximo(x);
            Frente = x;
            Final = x;
        } else {
            Final.setProximo(x);
            Final = x;
            Final.setProximo(Frente);
        }
    }
    public static void Desencolar() {
        if (Cola_Vacia()) {
            System.out.println("Cola Vacia.");
        } else {
            System.out.println("ID \tModelo \tCant \tPrecio \tTamaño");
            System.out.print(Frente.getID() + "\t");
            System.out.print(Frente.getModelo() + "\t");
            System.out.print(Frente.getCantidad() + "\t");
            System.out.print(Frente.getPrecio() + "\t");
            System.out.println(Frente.getTama());
            if (Frente != Final) {
                Frente = Frente.getProximo();
            } else {
                InicializaCola();
            }
        }
    }
    public static int Buscar(String Busqueda) {
        Mueble Aux = Frente;
        int cont = 0, existe = 0;
        for (int x = 0; x < TamCola(); x++) {
            cont++;
            if (Busqueda.equals(Aux.getModelo())) {
                existe++;
                break;
            } else {
                Aux = Aux.getProximo();
            }
        }
        if (existe == 1) {
            return cont;
        } else {
            return -1;
        }
    }
    public static void Consultar_Cola() {
        if (Cola_Vacia()) {
            System.out.println("Cola Vacia.");
        } else {
            Mueble Aux = new Mueble();
            Aux = Frente;
            System.out.println("A partir de que modelo.");
            String Busqueda = nc.nextLine();
            int Inicio=Buscar(Busqueda);
            if (Inicio!=-1) {
               for(int y=0;y<Inicio-1;y++){
                    Aux = Aux.getProximo();
                }
                System.out.println("ID \tModelo \tCant \tPrecio \tTam \tProximo");
                for (int x =Inicio;x<TamCola()+Inicio; x++) {
                    System.out.print(Aux.getID() + "\t");
                    System.out.print(Aux.getModelo() + "\t");
                    System.out.print(Aux.getCantidad() + "\t");
                    System.out.print(Aux.getPrecio() + "\t");
                    System.out.print(Aux.getTama() + "\t");
                        if (Aux.getProximo() == null) {
                            System.out.println(Aux.getProximo());
                        }else{
                            System.out.println(Aux.getProximo().getModelo());
                            }
                            Aux = Aux.getProximo();
                }
            } else {
                System.out.println("El modelo " + Busqueda + " no existe.");
            }
        }
    }
    public static void main(String[] args) {
        InicializaCola();
        int op = 0;
        while (op != 4) {
            System.out.println("1.Encolar 2.Desencolar 3.Consultar elementos de Cola 4.Terminar");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Encolar");
                    if ((Cola_Llena())) {
                        System.out.println("Cola llena por el final");
                    } else {
                        Mueble x = new Mueble();
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
                case 2:
                    System.out.println("Desencolar por el frente");
                    Desencolar();
                    break;
                case 3:
                    System.out.println("Elementos de la cola");
                    Consultar_Cola();
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
