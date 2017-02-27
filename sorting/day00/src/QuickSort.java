public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(n^2)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: n
     */
    @Override
    public int[] sort(int[] array) {
        if(isSorted(array)){
            return array;
        }
        else {
            quickSort(array, 0, array.length - 1);
            return array;
        }
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }


    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        for(int j = low + 1; j < high + 1; j++){
            if (array[j] < pivot){
                swap(array, i+1, j);
                i++;
            }
        }
        swap(array, low, i);
        return i;
    }

    public static boolean isSorted(int[] data){
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){
                return false;
            }
        }
        return true;
    }

}
