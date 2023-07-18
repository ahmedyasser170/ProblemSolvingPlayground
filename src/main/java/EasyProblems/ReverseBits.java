package EasyProblems;

public class ReverseBits {

    public static void main(String[] args) {
        int n = 00000000000000000000001010011101;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {

        int result = 0;
        for (int i=0;i<32;i++) {
            result = result<<1;
            if((n&1)==1)
                result++;
            n=n>>1;
        }

        return result;
    }
}
