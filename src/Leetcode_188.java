import java.util.HashMap;

class App {
    public static void main(String[] args) {
        App app = new App();
        int[] prices = {3,2,6,5,0,3};int k = 2;
//        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Stock max profit : "+app.maxProfit(k,prices) );
    }
    public int maxProfit(int k,int[] prices) {
        memProfit = new HashMap<>();
        return dynamicTrade(0,0,k,false,prices);
    }
    HashMap<String,Integer> memProfit;
    private int dynamicTrade(int day,int transaction,int k,boolean bought,int[] prices){
        if (day>= prices.length || transaction==k) return 0;
        String key = day+"-"+transaction+"-"+bought;
        if (memProfit.containsKey(key)) return memProfit.get(key);

        int profit = dynamicTrade(day+1,transaction,k,bought,prices);//skip
        if (bought) profit = Math.max( profit, dynamicTrade(day+1, transaction+1,k, false, prices) + prices[day] );//if(buy) profit = max(skip,sell)
        else profit = Math.max( profit,  dynamicTrade(day+1,transaction,k,true,prices) -prices[day] ); //if(!buy) profit = max(skip,buy)

        memProfit.put(key,profit);
        return profit;
    }

}
