import java.util.Arrays;
import java.util.HashMap;

public class DummyClass1 {
    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};
//        int prices[] = {2,1,2,1,0,1,2};


        int maxProfit = maxProfit(prices);
        System.out.println("Max Profit : "+maxProfit);
    }



    public static int maxProfit(int[] prices) {

        int lowestBuyingPrice = Integer.MAX_VALUE,maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestBuyingPrice){
                lowestBuyingPrice = prices[i];
            }
            if (prices[i]-lowestBuyingPrice>maxProfit){
                maxProfit = prices[i]-lowestBuyingPrice;
            }
        }
        return maxProfit;
    }

}
