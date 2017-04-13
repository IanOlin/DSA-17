import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

public class BillsNeeded {
    /** MEMO */
    int[] memo;
    //CONSTANTS

    int[] billDenominationsGlobal;
    //PUBLIC FUNCTION
    public int billsNeeded(int N, int[] billDenominations) {
        /** INITIALIZE THE MEMO */
        memo = new int[N+1];

        for (int i = 0; i < N+1; i++) {
                memo[i] = -1;
        }


        // SET GLOBAL CONSTANTS
        billDenominationsGlobal = billDenominations;


        // CALL RECURSIVE FUNCTION ON PROBLEM THAT YOU WANT TO SOLVE
        return recursiveFunction(N);
    }

    private int recursiveFunction(int N){ // Amount left to make and number of bills used

        // BASE CASES
        if (N == 0) {
            return 0;
        }


        /** HAS THIS BEEN MEMOIZED? */
        else if (memo[N] != -1) {
            return memo[N];
        }


        // RECURRENCE RELATION
        int[] numberBills = new int[billDenominationsGlobal.length];
        for (int i = 0; i < numberBills.length; i++) {
            //better way to do this?
            numberBills[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < billDenominationsGlobal.length; i++) {
            if (N - billDenominationsGlobal[i] >= 0) {
                numberBills[i] = recursiveFunction(N-billDenominationsGlobal[i])+ 1;
            }
        }
        Arrays.sort(numberBills);
        int best = numberBills[0];
        memo[N] = best;
        return best;


        /** UPDATE THE MEMO */


        // RETURN THE ANSWER


    }

}
