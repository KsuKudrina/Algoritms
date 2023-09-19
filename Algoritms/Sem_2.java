package Algoritms;
import java.util.Date;

public class Sem_2 {
    // public static void
    public static void sort1(int[] arr){ // Шейкерная сортировка O(n^2)
        int n = arr.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            for(int j = n - 1 - i; j > i; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void sort2(int[] arr){
        sort2(arr, 0, arr.length - 1);
    }

    public static int[] buff = new int[100001];
    public static void sort2(int[] arr, int left, int right){ // O(n * log n)
        if(left == right){
            return ;
        }
        int mid = (left + right) / 2;
        sort2(arr, left, mid);
        sort2(arr, mid + 1, right);

        // 4 5 6 1 2 3
        int i = left, j = mid+1, k = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                buff[k++] = arr[i++];
            }else{
                buff[k++] = arr[j++];
            }
        }

        while(i <= mid){
            buff[k++] = arr[i++];
        }

        while(j <= right){
            buff[k++] = arr[j++];
        }

        for(int q = left; q<=right; q++){
            arr[q] = buff[q];
        }
    }

    public static int BinarySearch(int[] arr, int val){ // O(log N)
        int left = 0, right = arr.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(arr[mid] >= val){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(arr[left] == val)
            return left;
        if(arr[right] == val)
            return right;
        return -1;
    }
    public static void main(String[] args) {
        int n = 100000;
        int[] arr1 = new int[n];
        //int[] arr2 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = (int)(Math.random() * 10000);
           //arr2[i] = arr1[i];
        }

        Date start = new Date();
        sort1(arr1);
        Date end = new Date();
        long time1 = end.getTime() - start.getTime();

        start = new Date();
        sort2(arr1);
        end = new Date();
        long time2 = end.getTime() - start.getTime();

        System.out.printf("time1 = %d, time2 = %d ", time1, time2);

        int pos = BinarySearch(arr1, 8);

        System.out.printf("pos = %d, arr[pos] = %d , arr[pos-1] = %d ", pos, arr1[pos], arr1[pos-1]);


    }
}

