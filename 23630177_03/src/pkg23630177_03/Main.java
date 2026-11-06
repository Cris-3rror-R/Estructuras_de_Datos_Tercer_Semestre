package pkg23630177_03;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner nc = new Scanner(System.in);
    static Mueble p[]= new Mueble[10];
    
    public static void Inicializar(){
        for(int x=0;x<10;x++){
           p[x]=new Mueble(0,"*",0,0,"*");
        }
    }
    public static int BuscarEspacio(){
        int Posi=-1;
        for(int x=0;x<10;x++){
            if(p[x].getModelo().equals("*")){
                Posi=x;
                break;
            }
        }
        return Posi;
    }
    public static int BuscarModelo(int Model){
        int Posi=-1;
        for(int x=0;x<10;x++){
            if(p[x].getID()==Model){
                Posi=x;
                break;
            }
        }
        return Posi;
    }
    public static void Insertar(){
        int Posi=BuscarEspacio();
        if(Posi==-1){
            System.out.println("Arreglo lleno");
        }else{
            System.out.println("ID:");
            p[Posi].setID(sc.nextInt());
            System.out.println("Modelo:");
            p[Posi].setModelo(nc.nextLine());
            System.out.println("Cantidad:");
            p[Posi].setCantidad(sc.nextInt());
            System.out.println("Precio:");
            p[Posi].setPrecio(sc.nextFloat());
            System.out.println("Tamaño(cm):");
            p[Posi].setTama(nc.nextLine());
        }
    }
    public static void Elimina(){
        System.out.println("ID a eliminar");
            int Posi =BuscarModelo(sc.nextInt());
        if(Posi==-1){
                System.out.println("El ID a eliminar no existe.");
            }else{
                p[Posi]=new Mueble(0,"*",0,0,"*");
        }
    }
    public static void Modicifica(){
        System.out.println("ID a modificar");
            int Posi =BuscarModelo(sc.nextInt());
        if(Posi==-1){
                System.out.println("El ID a modificar no existe.");
            }else{
                int a=0;
                while(a!=4){
                    System.out.println("1.Modelo  2.Cantidad  3.Precio  4.Tamaño(cm) 5.Salir");
                    a=sc.nextInt();
                        switch(a){
                            case 1:
                                System.out.println("Actulizar modelo:");
                                    p[Posi].setModelo(nc.nextLine());
                                break;
                            case 2:
                                System.out.println("Actualizar cantidad:");
                                    p[Posi].setCantidad(sc.nextInt());
                                break;
                            case 3:
                                System.out.println("Actualizar precio:");
                                    p[Posi].setPrecio(sc.nextFloat());
                                break;
                            case 4:
                                System.out.println("Actualizar tamaño:");
                                    p[Posi].setTama(nc.nextLine());
                                break;
                            default:
                                break;
                        }
                }
        }
    }
    public static void Consulta(){
        System.out.println("ID\tDescripcion\tCantidad\tPrecio\tTamaño(cm)");
        for(int x=0;x<10;x++){
            System.out.print(p[x].getID()+"\t");
            System.out.print(p[x].getModelo()+"\t");
            System.out.print(p[x].getCantidad()+"\t");
            System.out.print(p[x].getPrecio()+"\t");
            System.out.println(p[x].getTama());
        }
    }
    
    public static void main(String[] args) {
        int op=0;
            Inicializar();
            while(op!=6){
                System.out.println("1.Agregar 2.Eliminar 3.Modificar 4.Consultar 5.Buscar 6.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Agregar");
                        Insertar();
                        break;
                    case 2:System.out.println("Eliminar");
                        Elimina();
                        break;
                    case 3:System.out.println("Modificar");
                        Modicifica();
                        break;
                    case 4:System.out.println("Consulta");
                           Consulta(); 
                        break;
                    case 5:System.out.println("Buscar");
                           System.out.println("ID a buscar");
                            int cve=sc.nextInt();
                            if(BuscarModelo(cve)==-1){
                                System.out.println("El ID "+cve+" no existe.");
                            }else{
                                System.out.println("El ID si se encuentra.");
                            }
                        break;
                    case 6:
                        break;    
                    default:
                        break;    
                }
            }
            
    }
    
}
