public class SplitCoins {
    /** MEMO */
    int[][] memo; //all sums, by all pointers as you iterate through.

    //CONSTANTS
    int maxPointer;
    int sum;
    int[] coinsGlobal;

    //PUBLIC FUNCTION
    public int splitCoins(int[] coins) {
        for (int coin : coins) {
            sum += coin;
        }

        /** INITIALIZE THE MEMO */
        memo = new int[sum+1][coins.length];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }


        // SET GLOBAL CONSTANTS
        //sum
        maxPointer = coins.length;
        coinsGlobal = coins;


        // CALL RECURSIVE FUNCTION ON PROBLEM THAT YOU WANT TO SOLVE
        return recursiveFunction(0, 0);
    }

    private int recursiveFunction(int pile1, int pointer){

        // BASE CASES
        if (pointer == maxPointer){
//            System.out.println(((int) Math.ceil(sum/2.0 - pile1)));
//            return (int) Math.ceil(Math.abs(sum/2.0 - pile1));
            return sum - 2*pile1;
        }


        /** HAS THIS BEEN MEMOIZED? */
        if (memo[pile1][pointer] != -1) {
            return memo[pile1][pointer];
        }
//        System.out.print(((int) Math.ceil(sum/2.0 - pile1)));
        int x1 = recursiveFunction(pile1 + coinsGlobal[pointer], pointer + 1);
        int x2 = recursiveFunction(pile1, pointer +1);
        int best = Math.min(Math.abs(x1),Math.abs(x2));
        memo[pile1][pointer] = best;
//        System.out.println(best);
        return best;


        // RECURRENCE RELATION


        /** UPDATE THE MEMO */


        // RETURN THE ANSWER

    }
}
