package DSA.Foundation.Array;

public class SumOfArray {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        System.out.println(sumOfArray(arr));
    }

    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}
