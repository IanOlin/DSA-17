import java.util.*;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) { // n2 /n but only cause this isn't a map
        MyLinearMap map = new MyLinearMap();
        for(int i =0; i < arr.length; i++){
            if(map.get(arr[i]) == null){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i], (int) map.get(arr[i]) +1);
            }
        }
        return map;
    }

    public static List<Integer> removeKDigits(int[] num, int k) { //n/n
        LinkedList<Integer> list = new LinkedList();
        list.addLast(num[0]);
        for(int i =1; i < num.length; i++) {
            while(!list.isEmpty() && list.getLast() > num[i] && k> 0) {
                list.removeLast();
                k--;
            }
            list.addLast(num[i]);
        }

        while(k!=0){ //2N time, oops.
            list.removeLast();
            k--;
        }
        return list;
    }

    public static int sumLists(Node<Integer> h1, Node<Integer> h2) { //4N /1
        int sum = 0;
        int l1 = 0;
        int l2 = 0;
        Node<Integer> s1 = h1;
        Node<Integer> s2 = h2;
        while(h1.next != null){
            l1++;
            h1 = h1.next;
        }
        while(h2.next != null){
            l2++;
            h2 = h2.next;
        }
        while(s1.next != null){
            sum = sum + s1.data * (int) Math.pow(10, l1);
            l1--;
            s1 = s1.next;
        }
        while(s2.next != null){
            sum = sum + s2.data * (int) Math.pow(10, l2);
            l2--;
            s2 = s2.next;
        }
        return sum +s1.data +s2.data;
    }

}
