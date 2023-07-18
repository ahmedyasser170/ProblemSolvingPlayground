package EasyProblems;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
    public static int[] countBits(int n) {

        int[] countArray = new int[n+1];
        int count = 0;

        for (int i=0;i<=n;i++) {
            count = 0;
            int num = i;
            for (int j=0;j<32;j++)
            {
                count = count + (num&1);
                num = num >> 1;
            }
            countArray[i] = count;

        }

        return countArray;
    }

}
