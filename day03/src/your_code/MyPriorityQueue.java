package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> ll;

    public MyPriorityQueue(){
        ll = new LinkedList<>();
    }

    public void enqueue(int item) {
        int index = 0;
        if (ll.size() == 0){
            ll.add(item);
        }
        else {
            for (int i =0; i < ll.size(); i++) {
                if(item >= ll.get(i)){
                    index = i;
                    break;
                }
            }
            ll.add(index, item);
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        return ll.removeFirst();
    }

}