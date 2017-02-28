public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Recursively corrects the position of element indexed i: check children, and swap with larger child if necessary.
    public void heapify(int i) {
        if(size-1 >= rightChild(i)){
            if(heap[leftChild(i)] > heap[i] || heap[rightChild(i)]  > heap[i]){
                if (heap[leftChild(i)] > heap[rightChild(i)]){
                    swap(heap, leftChild(i), i);
                    heapify(leftChild(i));
                }
                else {
                    swap(heap, rightChild(i), i);
                    heapify(rightChild(i));
                }
            }
        }
        else if (size-1 == leftChild(i)){
            if (heap[leftChild(i)] > heap[i]){
                swap(heap, leftChild(i), i);
            }
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position.
    public void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        for(int i = size/2; i >= 0 ; i--){
            heapify(i);
        }
    }

    /**
     * Best-case runtime: O(nlogn)
     * Worst-case runtime: O(nlogn)
     * Average-case runtime: O(nlogn)
     *
     * Space-complexity: 1
     */
    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);
        for (int i=size-1; i>0; i--) {
            swap(heap, 0, i);
            size--;
            heapify(0);
        }
        return heap;
    }
}
