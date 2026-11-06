package pkg23630177_23;
import static java.lang.Math.*;
import java.util.*;
/*Cristopher Axel Venegas Venegas 
*Implementacion de BUSQUEDA BINARIA y SECUENCIAL
*Ordenamiento por BURBUJA SIMPLE
*/
public class Main {
    public static int [] Arr = new int[100];
    public static int [] ArreOrd = new int[100];
    public static int n=100;
    
    public static void GenerarArreglo(){
        Random random = new Random();
        for(int x=0;x<n;x++){
           Arr[x]=random.nextInt((n))+1;
        }
    }
    public static void ImprimeArreglo(int [] A){
      for(int x=0;x<n;x++){
            System.out.print(A[x]+" ");
        }
      System.out.println("");
    }
    public static int[] BurbujaSimple(int [] A){
        for(int j=0;j<n;j++){
            for(int k=j+1;k<n;k++){
                if(A[k]<A[j]){
                    int Aux=A[k];
                    A[k]=A[j];
                    A[j]=Aux;
                }
            }
        }
        return A;
    }
    public static boolean BuscaSecuencial(int [] A,int EB){
      for(int x=0;x<n;x++){
          if(EB==A[x]){
              return true;
          }
        }
      return false;
    }
    public static boolean BuscaBinaria(int [] A,int EB){
        int li=0,ls=A.length-1;
        int piv=0;
        while(li<=ls){
           piv=((ls-li)/2)+li;
                if(EB==A[piv]){
                    return true;
            }else{
                if(EB<A[piv]){
                    ls=piv-1;
              }else{
                    li=piv+1;
              }
           }
        }
      return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int op=0,EB;
        long TISecuencial,TFSecuencial,TTSecuencial,TIBinaria,TFBinaria,TTBinaria;
        GenerarArreglo();
        ArreOrd=BurbujaSimple(Arr);
            while(op!=2){
                System.out.println("1.Buscar un dato en el arreglo\t 2.Salir");
                op=sc.nextInt();
                    switch(op){
                        case 1:
                            System.out.println("Ingrese el numero a buscar en el arreglo");
                            EB=sc.nextInt();
                            TISecuencial=System.nanoTime();
                            if(BuscaSecuencial(ArreOrd,EB)){
                                TFSecuencial=System.nanoTime();
                                System.out.println("Si esta.Búsqueda Secuencial.");
                            }else{
                                TFSecuencial=System.nanoTime();
                                System.out.println("No esta.Búsqueda Secuencial.");
                            }
                            TTSecuencial=TFSecuencial-TISecuencial;
                            TIBinaria=System.nanoTime();
                            if(BuscaBinaria(ArreOrd,EB)){
                                TFBinaria=System.nanoTime();
                                System.out.println("Si esta.Búsqueda Binaria.");
                            }else{
                                TFBinaria=System.nanoTime();
                                System.out.println("No esta.Búsqueda Binaria.");
                            }
                            TTBinaria=TFBinaria-TIBinaria;
                            if(TTBinaria>TTSecuencial){
                                System.out.println("El metodo de busqueda secuencial es mejor, su tiempo fue "+TTSecuencial+"ns.");
                            }else{
                                System.out.println("El metodo de busqueda binario es mejor, su tiempo fue "+TTBinaria+"ns.");
                            }
                            break;
                        case 2:
                            System.out.println("Fin");
                            break;
                        default:
                            break;
                    }
            }
       
    }
    
}
