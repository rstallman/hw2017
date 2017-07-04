import java.util.Arrays;
import java.util.List;
/**
 * Created by lijinliang on 2017/7/3.
 */
public class TestArray {



//    public static int[][][] hellaDeepCopy(int[][][] array) {
//
//
//    }


    public static int[][] fibonacciArray(int n) {
        int[][] result = new int[n][];
        for(int i = 0; i < n; i++) {
            result[i] = new int[i+1];
            for(int j = 0; j < result[i].length; j++) {
                if(j == 0 ||  j == 1) {
                    result[i][j] = 1;
                }
                else {
                    result[i][j] = result[i][j-1] + result[i][j-2];
                }
            }
        }

        return result;
    }

    public static void printAll(int[][] array) {
        for (int i = 0; i < array.length; i += 1) {
            for (int j = 0; j < array[i].length; j += 1) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] arr = new int[4][];

        arr[0] = new int[]{1};
        arr[1] = new int[]{1, 1};
        arr[2] = new int[]{1, 2, 1};
        arr[3] = new int[]{1, 3, 3, 1};

        TestArray.printAll(arr);

        System.out.println("arr.length: " + arr.length);
        System.out.println("arr[0].length: " + arr[0].length);

        int[][] fib = TestArray.fibonacciArray(5);

        TestArray.printAll(fib);


        new Thread(()->System.out.println("In java 8, Lambda expression rocks!!")).start();

        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);


    }
}
