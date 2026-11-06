package pkg23630177_22;
import java.util.Scanner;
/**
 *Implementación de un ARBOL BINARIO con MEMORIA ESTATICA
 *Cristopher Axel Venegas Venegas
 */
public class Main{
    static Scanner sc=new Scanner(System.in);
    static Scanner nc=new Scanner(System.in);
    static Mueble[] Arbol = new Mueble[10];
    static int Disponible=0,Raiz=-1,Posi=0,Padre=0,TMax=10;
    static int[] HijoDer = new int[TMax],HijoIzq = new int[TMax];
    
    public static void InicializarArbol(){
        for(int x=0;x<TMax;x++){
            if(x!=TMax-1){
                HijoIzq[x]=x+1;    
            }else{
                HijoIzq[x]=-1;
            }
        }
        for(int z=0;z<TMax;z++){
            HijoDer[z]=-1;
        }
        for(int y=0;y<TMax;y++){
            Arbol[y]=new Mueble();
        }
        Disponible=0;
        Raiz=-1;
    }
    public static boolean ArbolVacio(){
        return Raiz==-1;
    }
    public static boolean ArbolLleno(){
        return Disponible==-1;
    }
    public static int Encontrar(Mueble Arbol[],int HijoDer[],int HijoIzq[],int item,int Raiz,int Posi,int Padre){
        int PTR=0,Salva=0;
        if(Raiz==-1){
            Posi=-1;
            Padre=-1;
            return Posi;
        }else{
            if(Arbol[Raiz].getID()==item){
               Posi=Raiz;
               Padre=-1;
            }else{
                if(item<Arbol[Raiz].getID()){
                    PTR=HijoIzq[PTR];
                    Salva=Raiz;
                }else{
                    PTR=HijoDer[PTR];
                    Salva=Raiz;
                }
            }
            while(PTR!=-1){
                if(item==Arbol[PTR].getID()){
                    Posi=PTR;
                    Padre=Salva;
                    return Posi;
                }
                if(item<Arbol[PTR].getID()){
                    Salva=PTR;
                    PTR=HijoIzq[PTR];
                }else{
                   Salva=PTR;
                   PTR=HijoDer[PTR]; 
                }
            }
        }
            System.out.println("No encontrado.");
            Posi=-1;
            Padre=Salva;
        return Posi;
    }
    public static void Insertar(Mueble Arbol[],int HijoIzq[],int HijoDer[],Mueble Item,int Raiz,int Disponible,int Posi){
        int Aux=Encontrar(Arbol,HijoDer,HijoIzq,Item.getID(),Raiz,Posi,Padre),Nuevo;
        Mueble[] Copiar=new Mueble[TMax];
            if(Posi==-1){
                return;
            }else{
                if(Disponible==-1){
                    System.out.println("Desbodamiento");
                    return;
                }else{
                    Copiar[Disponible]=Item;
                    Nuevo=Disponible;
                    Disponible=HijoIzq[Disponible];
                    Arbol[Nuevo]=Item;
                        if(Padre==-1){
                            Raiz=Nuevo;
                        }else{
                            if(Item.getID()<Arbol[Padre].getID()){
                                HijoIzq[Padre]=Nuevo;
                            }else{
                                HijoDer[Padre]=Nuevo;
                            }
                        }
                }
                
            }
    }
    public static void Mostrar(Mueble Arbol[],int HijoIzq[],int HijoDer[],int Raiz){
        int b=Raiz;
        while(b!=-1){
            System.out.println(HijoIzq[b]+"\t");
            System.out.print(Arbol[b].getID() + "\t");
            System.out.print(Arbol[b].getModelo() + "\t");
            System.out.print(Arbol[b].getCantidad() + "\t");
            System.out.print(Arbol[b].getPrecio() + "\t");
            System.out.print(Arbol[b].getTama());
            System.out.println(HijoDer[b]+"\t");
                b++;
                if(b==TMax){
                    b=0;
                }
                if("*".equals(Arbol[b].getModelo())){
                    b=-1;
                }
        }
    }
    public static void InOrden(Mueble Arbol[],int HijoIzq[],int HijoDer[],int Raiz){
        
    }
    public static void main(String[] args){
        InicializarArbol();
            int op=0;
            while(op!=4){
                System.out.println("1.Insertar 2.Eliminar 3.Recorrer 4.Terminar");
                op=sc.nextInt();
                switch(op){
                    case 1:System.out.println("Insertar");
                            if(ArbolLleno()){
                                System.out.println("Arbol lleno");
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
                                Insertar(Arbol,HijoIzq,HijoDer,x,Raiz,Disponible,Posi);
                            }
                        break;
                    case 2:System.out.println("Eliminar");
                            //Eliminar();
                        break;
                    case 3:System.out.println("Recorrer");
                            if(ArbolVacio()){
                                System.out.println("Arbol vacio");
                            }else{
                                System.out.println("1.InOrden\t 2.PreOrden\t 3.PosOrden");
                                int b=sc.nextInt();
                                    switch(b){
                                        case 1:
                                            System.out.println("InOrden");
                                            Mostrar(Arbol,HijoIzq,HijoDer,Raiz);
                                            break;
                                        case 2:
                                            System.out.println("PreOrden");
                                            break;
                                        case 3:
                                            System.out.println("PosOrden");
                                            break;
                                        default:
                                            break;
                                    }
                            }
                            
                        break;
                    case 4:System.out.println("Terminar");
                        break;    
                    default:
                        break;    
                }
            }
    }
    
}
