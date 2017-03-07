import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * Runtime: n+k
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        OptionalInt k = Arrays.stream(A).max();
        // could do the range from min to max things. but that's work and I'm lazy

        int[] buckets = new int[k.getAsInt()+1];

        for (int i : A) {
            buckets[i]++;
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0){
               A[index] = i;
               buckets[i]--;
               index++;
            }
        }
    }

}
