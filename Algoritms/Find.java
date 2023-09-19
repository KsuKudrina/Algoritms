package Algoritms;
public class Find {

    public static int find(int[] arr, int value)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == value)
            {
                return i;
            }
        }
        return -1;
    }    


    public static int binarySearch(int[] arr, int value, int min, int max){
        int midpoint;
        if(max < min){
            return -1;
        }
        else{
            midpoint = (max - min) / 2 + min;
        }
        if(arr[midpoint] < value){
            return binarySearch(arr, value, midpoint + 1, max);
        }
        else{
            if(arr[midpoint] > value){
                return binarySearch(arr, value, min, midpoint - 1);
            } else{
                return midpoint;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {
            5,8,6,4,9,1,7,3,2
        };
        // System.out.println(find(arr, 4));
        System.out.println(binarySearch(arr, 9, 0, arr.length -1));
    }
}
