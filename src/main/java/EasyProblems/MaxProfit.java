package EasyProblems;

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
//        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        int[] profitFromMin = new int[prices.length];
        for (int i=0;i<prices.length;i++)
        {
            min = Math.min(min, prices[i]);
            profitFromMin[i] = prices[i]-min;
            max=Math.max(max, profitFromMin[i]);
        }
        return max;
    }
}
