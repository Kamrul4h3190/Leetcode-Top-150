import java.util.*;

class App {
    public static void main(String[] args) {
        App app = new App();
//        int[] coins = {186,419,83,408};int amount = 6249;
//        int[] coins = {1,2,5};int amount = 100;
        int[] coins = {1,3,4};int amount = 5;
        System.out.println("min coins : "+app.coinChange(coins,amount));
    }

    int[] memAmount;
    public int coinChange(int[] coins, int amount) {//memoize recurring sub-amounts
        memAmount = new int[amount+1];
        Arrays.fill(memAmount,-1);
        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }
    int coinCount(int[] coins, int amount) {

        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if (memAmount[amount]!=-1) return memAmount[amount];

        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i]);
            if(ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1+ans);
            }
        }

        return memAmount[amount] = minCoins;
    }

//    public int coinChange(int[] coins, int amount) {// level recursion TLE
//        int ans = coinCount(coins, amount,0,Integer.MAX_VALUE);
//        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
//    }
//
//    int coinCount(int[] coins, int amount,int level,int minCoins) {
//
//        if(amount == 0) return level;
//        if(amount < 0) return Integer.MAX_VALUE;
//
//        for(int i = 0; i < coins.length; i++) {
//            int ans = coinCount(coins, amount - coins[i],level+1,minCoins);
//            if(ans != Integer.MAX_VALUE) {
//                minCoins = Math.min(minCoins, ans);
//            }
//        }
//        return minCoins;
//    }
}
