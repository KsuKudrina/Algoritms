package Algoritms;
public class Sort {

    public static void bubbleSort(int[] arr){
        boolean finish;
        do{
            finish = true;
            for (int i = 0; i < arr.length -1; i++) {
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    finish = false;
                }
            }
        }while(!finish );
        
    }

    public static void directSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minPosition]){
                    minPosition = j;
                }
            }
            if (i != minPosition){
                    int temp = arr[i];
                    arr[i] = arr[minPosition];
                    arr[minPosition] = temp;
                }
        }
    }

    public static void insterSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[] {4,2,5,8,1,9,3,6,7,2};

        // bubbleSort(arr);
        // directSort(arr);
        // insterSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
