package your_code;

import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> max;

    public MyStack() {
        ll = new LinkedList<>();
        max = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if (max.isEmpty() || e > max.getFirst()){
            max.addFirst(e);
        }
    }

    @Override
    public Integer pop() {
        int res = ll.removeFirst();
        if(max.getFirst() == res){
            max.removeFirst();
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        if(max.isEmpty() && !ll.isEmpty()){
            int maximum = Integer.MIN_VALUE;
            for(int i =0; i < ll.size() ;i++){
                if (ll.get(i)>maximum ){
                    maximum = ll.get(i);
                }
            }
            max.addFirst(maximum);
        }
        return max.getFirst();
    }
}
