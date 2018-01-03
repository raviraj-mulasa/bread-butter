package net.geekscore.bit;

/**
 *Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 231.
 * Example:
 *  Input: x = 1, y = 4
 *  Output: 2
 *
 *  Explanation:
 *  1   (0 0 0 1)
 *  4   (0 1 0 0)
 *          ↑   ↑
 *  The above arrows point to positions where the corresponding bits are different.

 */
public class HammingDistance {

    public static void main(String[] args) {

        System.out.println(hammingWeight( 1 ^ 4));  // 1 - 0001,  4 - 0100
        System.out.println(hammingWeight( 11 ^ 4));  // 11 - 1011, 4 - 0100
        System.out.println(hammingWeight( 15 ^ 0));  // 15 - 1111, 0 - 0000
        System.out.println(hammingWeight( 15 ^ 15));  // 15 - 1111, 15 - 1111
        System.out.println(hammingWeight( 0 ^ 0));  // 0 - 0000, 15 - 0000

    }

    private static final int hammingWeight(final int x){
        int weight = 0;
        int temp = x;
        while (temp != 0){
            weight += (temp & 1);
            temp = temp >> 1;
        }
        return weight;
    }
}
