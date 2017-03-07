import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        System.out.println(A.toString());
//        System.out.println('@');

        A = Arrays.stream(A).map(i -> i+100).toArray();
//        Arrays.stream(A).forEach(System.out::println);

        CountingSort hund = new CountingSort();
        hund.countingSort(A);

//        System.out.println('#');
//        Arrays.stream(A).forEach(System.out::println);
        A = Arrays.stream(A).map(i -> i-100).toArray();

        System.out.println();
        System.out.println(A.toString());
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        LinkedList<String>[] alphabet = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new LinkedList<>();
        }
        for (String i : A) {
            alphabet[getNthCharacter(i, n)].add(i);
        }

        int index =0;
        for (LinkedList<String> i : alphabet) {
            for (String j : i) {
                A[index] = j;
                index++;
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for (int i = 0; i < stringLength; i++) {
            countingSortByCharacter(S, i);
        }
    }

}
