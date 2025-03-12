import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
//        int [] prices = {7,2,1,4,5,3,6,4};
//        int [] prices = {1,2,3,4,5};

        int maxProfit = maxProfit(prices);
        System.out.println("max profit : "+ maxProfit);

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length; if (n<2) return maxProfit;

        int buyPrice = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i]<prices[i-1]){
                buyPrice = prices[i];
            } else if (prices[i]>buyPrice && prices[i]>prices[i-1]) {
                maxProfit += prices[i]-prices[i-1];
            }
        }

        return maxProfit;
    }
}
