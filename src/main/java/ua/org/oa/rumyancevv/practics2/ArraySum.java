package ua.org.oa.rumyancevv.practics2;

/**
 * Created by user on 26.01.2016.
 */
public class ArraySum {

    public int[] arr;

    public ArraySum(int[] arr) {
        this.arr = arr;
    }

    public int Sum(){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int Sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    

}
