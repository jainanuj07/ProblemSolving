/**
 * Problem :
 * The greatest Common Divisor (GCD) also called highest common factor(HCF)
 * of N numbers is the largest positive integer that divides all numbers without giving a remainder.
 * <p>
 * Write an algorithm to determine the GCD of N Positive integers.
 * <p>
 * Input :
 * The input to the function consists of two arguments -
 * num - an integer representing the num of positive integers (N)
 * arr - a list of positive integers
 * <p>
 * Output :
 * Return an integer representing the GCD of the given positive integers.
 * <p>
 * <p>
 * Example :
 * num -5
 * [2,4,6,8,10]
 * <p>
 * Output - 2
 */

public class GCD {
    public static void main(String args[]) {
        System.out.println(56 % 98);
        System.out.println(gcd(98, 56));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int generalizedGCD(int num, int a[]) {
        int result = a[0];

        for (int i = 1; i < a.length; i++) {
            result = gcd(a[i], result);
        }
        return result;
    }


}
