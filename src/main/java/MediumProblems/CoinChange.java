package MediumProblems;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
//        int[] coins = {1,2,5};
        int[] coins = {2};
        System.out.println(coinChange(coins, 6));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int[] amountArray = new int[amount+1];
        Arrays.fill(amountArray,amount+1);
        amountArray[0] = 0;
        for (int i=0;i<amount+1;i++)
        {
            for (int j=0;j<coins.length;j++)
            {
                if (coins[j]<=i)
                    amountArray[i] = Math.min(amountArray[i-coins[j]]+1,amountArray[i]);
            }
        }

        return amountArray[amount]>amount?-1:amountArray[amount];
    }

}
