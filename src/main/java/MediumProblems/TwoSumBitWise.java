package MediumProblems;

public class TwoSumBitWise {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3|2));
        int x = 3;
        Integer.toBinaryString(x);
        int y = x-1;
        Integer.toBinaryString(y);
        int z = x&y;
        Integer.toBinaryString(z);
        int c = x^z;
        System.out.println(c);
        System.out.println(getSum(7,7));
    }
    public static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            Integer.toBinaryString(a);
            Integer.toBinaryString(b);
            a = (a ^ b);
            Integer.toBinaryString(a);
            Integer.toBinaryString(b);
            b = tmp;
        }
        return a;
    }
}
