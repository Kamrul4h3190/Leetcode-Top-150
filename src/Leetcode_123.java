import java.util.HashMap;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] prices = {1,2,3,4,5};
//        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Stock max profit : "+app.maxProfit(prices) );
    }
    public int maxProfit(int[] prices) {
        memProfit = new HashMap<>();
        return dynamicTrade(0,0,false,prices);
    }
    HashMap<String,Integer> memProfit;
    private int dynamicTrade(int day,int transactions,boolean bought,int[] prices){
        if (day>= prices.length || transactions==2) return 0;
        String key = day+"-"+transactions+"-"+bought;
        if (memProfit.containsKey(key)) return memProfit.get(key);

        int profit = dynamicTrade(day+1,transactions,bought,prices);//skip
        if (bought) profit = Math.max( profit, dynamicTrade(day+1, transactions+1, false, prices) + prices[day] );//if(buy) profit = max(skip,sell)
        else profit = Math.max( profit,  dynamicTrade(day+1,transactions,true,prices) -prices[day] ); //if(!buy) profit = max(skip,buy)

        memProfit.put(key,profit);
        return profit;
    }

}
