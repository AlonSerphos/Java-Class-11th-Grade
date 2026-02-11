package QuickSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 3, 9, 10, 6, 4};
        quick(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int loc1, int loc2, int[] arr) {
        if (loc1 == loc2) {
            return;
        }
        int originalLoc1 = loc1;
        int replaceLoc = loc1;
        for (int i = loc1 ; i <= loc2 ; i++) {
            if (arr[loc1] <= arr[loc2]) {
                int temp = arr[replaceLoc];
                arr[replaceLoc] = arr[loc1];
                arr[loc1] = temp;
                replaceLoc++;
            }
            loc1++;
        }
        if (replaceLoc-1 != loc2) {
            quick(replaceLoc, loc2, arr);
        }
        if (replaceLoc != originalLoc1) {
            quick(originalLoc1, replaceLoc-2, arr);
        }
    }
}
