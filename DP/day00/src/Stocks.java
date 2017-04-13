public class Stocks {

    public int maxProfit(int[] prices) {
        int buy, sell, profit;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = prices[i];
            for (int j = i; j < prices.length; j++) {
                sell = prices[j];
                profit = sell - buy;
                if (profit > max){
                    max = profit;
                }
            }
        }
        return max;
    }

    public int maxProfitWithK(int[] prices, int k) {
        // TODO: Optional
        return -1;
    }

}
