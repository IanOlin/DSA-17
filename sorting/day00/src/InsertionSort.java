
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: O(n)
     * Worst-case runtime: O(n^2)
     * Average-case runtime: O(n^2)
     *
     * Space-complexity: 1
     */
    @Override
    public int[] sort(int[] array) {
        for(int i =0; i < array.length; i++){
            int j = i;
            while(j > 0 && array[j] < array[j-1]){
                swap(array,j,j-1);
                j = j-1;
            }
        }
        return array;
    }
}
