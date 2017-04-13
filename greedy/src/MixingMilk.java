
public class MixingMilk {
    public static int solve(int M, int N, int[] units, int[] price) {
        int money = 0;
        while (M > 0) {
            int minPrice = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < N; i++) {
                if (units[i] > 0){
                    if (price[i] < minPrice) {
                        minPrice = price[i];
                        index = i;
                    }
                }
            }
            // Write any form of better code here please god.
            units[index]--;
            M--;
            money += price[index];
        }
        return money;
    }
}
