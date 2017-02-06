package your_code;

import ADTs.StackADT;

import java.util.Stack;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        Stack myStack = new Stack();
        int length =0;
        int max =0;
        String[] input = s.split("");
        for (int i =0; i < input.length; i++){
            if(input[i].equals("(")){
                myStack.push(input[i]);
            }
            if(input[i].equals(")")){
                if(myStack.isEmpty()){
                    length = 0;
                }
                else {
                    myStack.pop();
                    length += 2;
                }
            }
            if (length > max){
                max = length;
            }
        }

        return max;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        MyStack helper = new MyStack();
        int current;

        while(!s.isEmpty()){
            current = s.pop();

            while (!helper.isEmpty() && current > helper.peek()){
                s.push(helper.pop());
            }
            helper.push(current);
        }
        return helper;
    }

}
