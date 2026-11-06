package pkg23630177_24;
import java.util.Scanner;
/**
*Cristopher Axel Venegas Venegas
*Metodos de ordenamiento
*Autor: Juan González
*El video que vi el algoritmo de burbuja mejorada fue
*https://www.youtube.com/watch?v=nkPo48sHOyU
* El algoritmo para el HeapSort, utilizo el código de arbol binario con
* memoría dinamica con sus ajustes.
* El algoritmo de MergetSort se uso el que se vio en clases y el de las notas
* de clase.
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static MisMetodos mm = new MisMetodos();
    static Nodo NodoArr;
    static int AAux [];
    static int cont;
    public static int[] BurbujaSimple(int [] A){
        for(int j=0;j<A.length-1;j++){
            for(int k=j+1;k<A.length;k++){
                if(A[k]<A[j]){
                    int Aux=A[k];
                    A[k]=A[j];
                    A[j]=Aux;
                }
            }
        }
        return A;
    }
    public static int[] BurbujaMejorada(int [] A){
        for(int j=0;j<A.length-1;j++){
            boolean Bandera=false;
                for(int k=j+1;k<A.length;k++){
                    if(A[k]<A[j]){
                        int Aux=A[k];
                        A[k]=A[j];
                        A[j]=Aux;
                        Bandera=true;
                    }
                }
                    if(!Bandera){
                        break;
                    }
            }
        return A;
    }
    public static int[] QuickSort(int [] A){
        return Qs(A,0,A.length-1);
    }
    public static int[] Qs(int [] A,int inf,int sup){
        int der,izq,mitad,x;
        izq=inf;
        der=sup;
        mitad=A[(sup+inf)/2];
        do{
            while((A[izq]<mitad)&&(izq<sup)){
                izq++;
            }
            while((mitad<A[der])&&(der>inf)){
                der--;
            }
                if(izq<=der){
                    x=A[izq];
                    A[izq]=A[der];
                    A[der]=x;
                    izq++;
                    der--;
                }
        }while(izq<=der);
            if(inf<der){
                Qs(A,inf,der);
            }
            if(izq<sup){
                Qs(A,izq,sup);
            }
        return A;    
    }
    public static void CrearArbol(int [] A){
        NodoArr=null;
        for(int x=0;x<A.length;x++){
            Nodo NodoIns=new Nodo();
            NodoIns.setDato(A[x]);
            InsertarNodo(NodoIns);
        }
    }
    public static void InsertarNodo(Nodo NodoIns) {
        NodoArr=Insertar(NodoArr,NodoIns);
    }
    public static Nodo Insertar(Nodo NodoArr,Nodo NodoIns){
        if(NodoArr==null){
            NodoArr=NodoIns;
        }else{
            if(NodoIns.getDato()<NodoArr.getDato()){
                NodoArr.setHijoIzquierdo(Insertar(NodoArr.getHijoIzquierdo(),NodoIns));
            }else{
                NodoArr.setHijoDerecho(Insertar(NodoArr.getHijoDerecho(),NodoIns));
            }
        }
        return NodoArr;
    }
    public static void InOrden(Nodo NodoArr){
        if(NodoArr!=null){
            InOrden(NodoArr.getHijoIzquierdo());
            if(cont<AAux.length){
                AAux[cont]=NodoArr.getDato();
                cont++;
            }
            InOrden(NodoArr.getHijoDerecho());
        }
    }
    public static int [] HeapSort(int [] A){
        CrearArbol(A);
        AAux=new int [A.length];
        cont=0;
        InOrden(NodoArr);
        return AAux;
    }
    public static int [] MergeSort(int []A,int[]B){
        int [] C = new int[A.length+B.length];
        int a=0,b=0,c=0;
        while((a<A.length)&&(b<B.length)){
                if(A[a]>B[b]){
                    C[c]=B[b];
                    b++;
                }else{
                    C[c]=A[a];
                    a++;
                }
                c++;
        }
        if(a==A.length){
                for(int x=b;x<=B.length-1;x++){
                    C[c]=B[x];
                    c++;
                }
            }else{
                for(int x=a;x<=A.length-1;x++){
                    C[c]=A[x];
                    c++;
                }
            }
        return C;
    }
    public static void Radix(int [] A){
        int [][] Bucket = new int[10][A.length];
        int [] BucketOut = new int[10];
        int Max=0;
            for(int x=0;x<A.length;x++){
                if(A[x]>Max){
                    Max=A[x];
                }
                int MaxLeg=(Max+"").length();
                    for(int m=0,n=1;m<MaxLeg;m++,n*=10){
                        int digit=A[x]/n%10;
                        Bucket[digit][BucketOut[digit]]=A[x];
                        BucketOut[digit]++;
                   }
                int index=0;
                    for(int z=0;z<10;z++){
                        for(int w=0;w<BucketOut[z];w++){
                            A[index]=Bucket[z][w];
                            index++;
                        }
                        BucketOut[z]=0;
                    }
            }
    }
    
    public static void main(String[] args) {
        int op=0;
        int TamArr=0;
        long Ti,Tf,TtBs,TtBm,TtQs,TtHs;
        System.out.println("Tamaño del arreglo");
        TamArr=sc.nextInt();
        int [] A=mm.GenerarArreglo(TamArr);
        mm.ImprimeArreglo(A);
        System.out.println("Metodos de ordenamiento");
        do{
            System.out.println("1.Burbuja simple\t 2.Burbuja mejorada\t 3.QuickSort\t 4.HeapSort\n 5.MergeSort\t 6.Evaluar los metodos de ordenamiento\t 7.Radix\t 8.Finalizar");
                op=sc.nextInt();
                switch(op){
                    case 1:
                        System.out.println("Burbuja simple");
                            mm.ImprimeArreglo(BurbujaSimple(A));
                        break;
                    case 2:
                        System.out.println("Burbuja Mejorada");
                            mm.ImprimeArreglo(BurbujaMejorada(A));
                        break;
                    case 3:
                        System.out.println("QuickSort");
                            mm.ImprimeArreglo(QuickSort(A));
                        break;
                    case 4:
                        System.out.println("HeapSort");
                            mm.ImprimeArreglo(HeapSort(A));
                        break;
                    case 5:
                        System.out.println("MergeSort");
                            int [] B=mm.GenerarArreglo(TamArr);
                            mm.ImprimeArreglo(MergeSort(QuickSort(A),QuickSort(B)));
                        break;
                    case 6:
                        //.clone(),es necesario
                        System.out.println("Evaluacion de metodos de ordenamiento");
                        Ti=System.nanoTime();
                        BurbujaSimple(A.clone());
                        Tf=System.nanoTime();
                        TtBs=Tf-Ti;
                        System.out.println("Burbuja simple: "+TtBs+" ns.");
                        Ti=System.nanoTime();
                        BurbujaMejorada(A.clone());
                        Tf=System.nanoTime();
                        TtBm=Tf-Ti;
                        System.out.println("Burbuja mejorada: "+TtBm+" ns.");
                        Ti=System.nanoTime();
                        QuickSort(A.clone());
                        Tf=System.nanoTime();
                        TtQs=Tf-Ti;
                        System.out.println("QuickSort: "+TtQs+" ns.");
                        Ti=System.nanoTime();
                        HeapSort(A.clone());
                        Tf=System.nanoTime();
                        TtHs=Tf-Ti;
                        System.out.println("HeapSort: "+TtHs+" ns.");
                            if((TtBs<TtBm)&&(TtBs<TtQs)&&(TtBs<TtHs)){
                                System.out.println("Burbuja simple es el más eficiente.");
                            }else{
                                if((TtBm<TtBs)&&(TtBm<TtQs)&&(TtBm<TtHs)){
                                    System.out.println("Burbuja mejorada es el más eficiente.");
                                }else{
                                    if((TtQs<TtBs)&&(TtQs<TtBm)&&(TtQs<TtHs)){
                                        System.out.println("QuickSort es el más eficiente.");
                                    }else{
                                        System.out.println("HeapSort es el más eficiente.");
                                    }
                                }
                            }
                        break;
                    case 7:
                        System.out.println("Radix");
                            Radix(A);
                            for(int x=0;x>A.length;x++){
                                System.out.println(A[x]);
                            }
                        break;
                    case 8:
                        System.out.println("Fin");
                        break;
                    default:
                        break;
                }
        }while(op!=8);
    }
    
}
