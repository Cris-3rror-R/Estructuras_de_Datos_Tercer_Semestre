package pkg23630177_04;
import java.util.Scanner;
/**
Cristopher Axel Venegas Venegas
*Programa que implemente soluciones iteractivas vs recursivas
* evaluando su complejidad temporal.
*/
public class Main {
    static Scanner sc= new Scanner(System.in);
    public static long FactorialIterativo(int n){
        long f=1,ti,tf,tt;
        ti=System.nanoTime();
            for(int x=n;x>1;x--){
                        f=f*x;
                    }
        tf=System.nanoTime();
        System.out.println("El factorial iterativo de "+n+" es "+f);
        tt=tf-ti;
        System.out.println("Tiempo de ejecución:"+tt+" ns.");
        return tt;
    }
    public static long FactorialRecursivo(int n){
        long f,ti,tf,tt;
        ti=System.nanoTime();
        f=Factorial(n);
        tf=System.nanoTime();
        System.out.println("El factorial recursivo de "+n+" es "+f);
        tt=tf-ti;
        System.out.println("Tiempo de ejecución:"+tt+" ns.");
        return tt;
    }
    public static long Factorial(int n){
            if(n<=1){
               return 1;
           }else{
               return n*Factorial(n-1);
           }
    }
    public static long SumaIterativa(int n){
        int f=0;
        long ti,tf,tt;
        ti=System.nanoTime();
            for(int x=n;x>0;x--){
                f=f+x;
        }
            tf=System.nanoTime();
            System.out.println("La sumatoria iterativa de "+n+" es "+f);
            tt=tf-ti;
            System.out.println("Tiempo de ejecución:"+tt+" ns.");
            return tt;
    }
    public static int Suma(int n){
        if(n==1){
            return 1;
        }else{
            return n+Suma(n-1);
        }
    }
    public static long SumaRecursiva(int n){
        int f=0;
        long ti,tf,tt;
            ti=System.nanoTime();
            f=Suma(n);
            tf=System.nanoTime();
            System.out.println("La sumatoria recursiva de "+n+" es "+f);
            tt=tf-ti;
            System.out.println("Tiempo de ejecución:"+tt+" ns.");
            return tt;
    }
    public static long FibonacciIterativo(int n){
        int a=0,b=1,c;
        long ti,tf,tt;
            System.out.print("La serie de Fibonacci iteractiva es ");
            ti=System.nanoTime();
            for(int x=0;x<=n;x++){
                System.out.print(a+",");
                c=a+b;
                a=b;
                b=c;
            }
            tf=System.nanoTime();
            tt=tf-ti;
            System.out.println("");
            System.out.println("Tiempo de ejecución:"+tt+" ns.");
        return tt;
    }
    public static int Fibonacci(int n){
        if(n<=1){
            return n;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
    public static long FibonacciRecursivo(int n){
        long ti,tf,tt;
            System.out.print("La serie de Fibonacci recursiva de ");
            ti=System.nanoTime();
                for(int x=0;x<=n;x++){
                    System.out.print(Fibonacci(x)+",");
                }
            tf=System.nanoTime();
            tt=tf-ti;
            System.out.println("");
            System.out.println("Tiempo de ejecución:"+tt+" ns.");
            return tt;
    }
        public static long MultiSumaIterativas(int n,int m){
            int s=0;
            long ti,tf,tt;
                ti=System.nanoTime();
                for(int x=0;x<n;x++){
                    s=s+m;
                }
                tf=System.nanoTime();
                tt=tf-ti;
                System.out.println("La multiplicacion iterativa con sumas repetivas es "+s);
                System.out.println("Tiempo de ejecución:"+tt+" ns.");
                return tt;
        }
        public static int MultiplicacionSuma(int n,int m){
        if(m<=0){
            return 0;
        }else{
            return n+MultiplicacionSuma(n,m-1);
        }
    }
        public static long MultiSumaRecursiva(int n,int m){
            int s;
            long ti,tf,tt;
            ti=System.nanoTime();
            s=MultiplicacionSuma(n,m);
            tf=System.nanoTime();
            tt=tf-ti;
            System.out.println("La multiplicacion recursiva con sumas repetivas es "+s);
            System.out.println("Tiempo de ejecución:"+tt+" ns.");
            return tt;
        }
        public static long DiviRestaIterativas(int n,int m){
            int c=1,o=n;
            long ti,tf,tt;
                ti=System.nanoTime();
                    while(n>m){
                        n=n-m;
                        c++;
                    }
                tf=System.nanoTime();
                tt=tf-ti;
                System.out.println("La division iterativa con restas repetivas "+o+"/"+m+" es "+c);
                System.out.println("Tiempo de ejecución:"+tt+" ns.");
                return tt;
        }
        public static int DiviResta(int n,int m){
        if(n<m){
            return 0;
        }else{
            return 1+DiviResta(n-m,m);
        }
    }
        public static long DiviRestaRecursiva(int n,int m){
            int c;
            long ti,tf,tt;
                ti=System.nanoTime();
                c=DiviResta(n,m);
                tf=System.nanoTime();
                tt=tf-ti;
                System.out.println("La division recursiva con restas repetivas es "+c);
                System.out.println("Tiempo de ejecución:"+tt+" ns.");
                return tt;
        }
    public static void main(String[] args) {
        int opcion=0,n,m;
        while(opcion!=6){
            System.out.println("---------MENU-----------");
            System.out.println("1.Sumatoria");
            System.out.println("2.Factorial");
            System.out.println("3.Sucesion de Fibonacci");
            System.out.println("4.Multiplicacion con sumas sucesivas.");
            System.out.println("5.Divison con restas sucesivas.");
            System.out.println("6.Fin");
            opcion=sc.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el valor de N");
                        n=sc.nextInt();
                            if(SumaRecursiva(n)>SumaIterativa(n)){
                                System.out.println("La suma iterativa es más eficiente.");
                            }else{
                                System.out.println("La suma recursiva es más eficiente.");
                            }
                        break;
                    case 2:
                        System.out.println("Ingrese el valor de N");
                        n=sc.nextInt();
                            if(FactorialRecursivo(n)>FactorialIterativo(n)){
                                System.out.println("El factorial iterativo es más eficiente.");
                            }else{
                                System.out.println("El factorial recursivo es más eficiente.");
                            }   
                        break;
                    case 3:
                        System.out.println("Ingrese el valor de N");
                        n=sc.nextInt();
                             if(FibonacciRecursivo(n)>FibonacciIterativo(n)){
                                System.out.println("La serie de Fibonacci iterativa es más eficiente.");
                            }else{
                                System.out.println("La serie de Fibonacci recursiva es más eficiente.");
                            } 
                        break;
                    case 4: 
                            System.out.println("Ingrese el valor de N");
                                n=sc.nextInt();
                            System.out.println("Ingrese el valor de M");
                                m=sc.nextInt();
                             if(MultiSumaRecursiva(n,m)>MultiSumaIterativas(n,m)){
                                System.out.println("La Multiplicacion iterativa con sumas es más eficiente.");
                            }else{
                                System.out.println("La Multiplicacion recursiva con sumas es más eficiente.");
                            }   
                        break;
                    case 5:
                            System.out.println("Ingrese el valor de N");
                                n=sc.nextInt();
                            System.out.println("Ingrese el valor de M");
                                m=sc.nextInt();
                             if(DiviRestaRecursiva(n,m)>DiviRestaIterativas(n,m)){
                                System.out.println("La Division iterativa con restas es más eficiente.");
                            }else{
                                System.out.println("La Division recursiva con restas es más eficiente.");
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
