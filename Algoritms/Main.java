package Algoritms;
import java.util.Date;



public class Main {

    // sem1
    
    public int sum(int N){
        int sumN = 0;
        for (int i = 1; i <= N; i++) {
            sumN = sumN + i;
        }
        return sumN;
    }

    public static void simple(int N){
        for (int i = 2; i <= N; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0){
                    ok = false;
                    break;
                }
            }
            if (ok){
                System.out.printf("%d ", i);
            }
        }
    }

    public static int[] arr = new int[100];
    
    public static void cubes(int K, int N, int d){
        if(d == K){
            for (int i = 0; i < K; i++) {
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=N; i++) {
            arr[d] = i;
            cubes(K, N, d+1);
        }
       
    }

    public static int fib1(int n){  // O(2^n)
        if (n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n){  // O(n)
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i -1] + F[i - 2];
        }
        return F[n];
    }

    public static void test(){
        for (int i = 10; i <= 50; i++) {
            Date start = new Date();
            fib1(i);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            fib2(i);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("i: %d, time1: %d, time2: %d%n", i, time1, time2);
        }
    }
    public static void main(String[] args) {
        // simple(100);
        // cubes(4, 6, 0);
        // System.out.println(fib1(10)); 
        // System.out.println(fib2(10));
        test();
    }
}