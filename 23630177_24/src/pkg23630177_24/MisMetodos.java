package pkg23630177_24;
import java.util.Random;
import java.util.Scanner;
/**
 *Cristopher Axel Venegas Venegas 
 *Metodos auxiliares
 */
public class MisMetodos {
    
    //Crea un arreglo de enteros de tamano n
    public int[] GenerarArreglo(int n){
        int[] Arr= new int[n];
        Random random = new Random();
        for(int x=0;x<n;x++){
           Arr[x]=random.nextInt((n))+1;
        }
        return Arr;
    }
    public void ImprimeArreglo(int [] A){
      for(int x=0;x<A.length;x++){
            System.out.print(A[x]+" ");
        }
      System.out.println("");
    }
    
    
}
