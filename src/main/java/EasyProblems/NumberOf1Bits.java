package EasyProblems;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
//        int n = 0000000000000000000000000000101;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int counter = 0;

        for (int i=0;i<32;i++)
        {
            counter = counter + (n&1);
            n = n>>>1;
        }

        return counter;
    }
}
