import java.util.Arrays;

public class Shift {

    public static void shiftDown(int[] a) {
        if (a==null || a.length<2) return; // edge cases
        int n = a.length, temp = a[0]; // temp is placeholder for first value in array
        for (int i=0; i<n-1;i++) a[i] = a[i+1]; // for length of array-1, shift values up by 1
        a[n-1] = temp; // set value of a.length-1 to temp value
    }

    public static void main(String[] args) {
        int[] b = {1,2,3,4,5,6};

        System.out.println("Before shiftDown: " + Arrays.toString(b));
        shiftDown(b);
        System.out.println("After shiftDown:  " + Arrays.toString(b));
        System.out.println();
    }
}
