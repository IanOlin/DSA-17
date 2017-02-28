import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     *
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime:O(nlogn)
     *
     * Space-complexity: O(nlong) -> n
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1){
            return array;
        }

        int[] left = sort(Arrays.copyOfRange(array, 0, array.length/2));
        int[] right = sort(Arrays.copyOfRange(array, array.length/2, array.length));

        return merge(left, right);


    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     */
    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        if (a.length + b.length <= INSERTION_THRESHOLD){
            System.arraycopy(a, 0 ,res, 0, a.length);
            System.arraycopy(b, 0, res, a.length, b.length);
            InsertionSort isort = new InsertionSort();
            res = isort.sort(res);
        }

        else {
            int i = 0;
            int j = 0;

            while (i < a.length && j < b.length) {
                res[i + j] = Math.min(a[i], b[j]);
                if (a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            if (i == a.length) {
                while (j < b.length) {
                    res[i + j] = b[j];
                    j++;
                }
            }
            if (j == b.length) {
                while (i < a.length) {
                    res[i + j] = a[i];
                    i++;
                }
            }
        }
        return res;
    }

}
