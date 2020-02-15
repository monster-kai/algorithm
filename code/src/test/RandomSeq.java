package test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Ryan
 * @data 2020/02/12 - 周三
 */
public class RandomSeq {
    public static void main(String[] args) {
        String a = "1";  //Integer.parseInt() the String transform to Integer should be number, like "1", "5"
                        // or java.lang.NumberFormatException
        int n = Integer.parseInt(a.trim()); // a.trim() with all leading and trailing space is removed
        System.out.println(n);

        int N = Integer.parseInt(args[0]);
        //Parses the string argument as a signed decimal integer.
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
